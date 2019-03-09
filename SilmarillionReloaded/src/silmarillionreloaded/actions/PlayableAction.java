/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import java.awt.Point;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player.RegularPlayer;
import silmarillionreloaded.renderableObjects.SpriteAnimation;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public abstract class PlayableAction {
    
    
    private final Game game;
    
    public PlayableAction(final Game game) {
        this.game = game;
    }
    public abstract void execute();
    public abstract boolean isExecutable();
    
    public static abstract class ActionOnTile extends PlayableAction {
        
        private final Tile tile;
        public ActionOnTile(Game game, Tile tile) {
            super(game);
            this.tile = tile;
        }
        
        
        
    }
    public static abstract class ActionOnPiece extends PlayableAction {
        private final Piece piece;
        public ActionOnPiece(Game game, final Piece piece) {
            super(game);
            this.piece = piece;
        }
        
    }
    public static abstract class Action extends PlayableAction {
        public Action(Game game) {
            super(game);
        }
    }
    
    public static Action CollectItem(final Game game) {
        return new Action(game) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Cant collect item!");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Tile tile = game.getWorld().getPiecesOnWorld().get(game.selectedObject.getPiece());
                Item item = tile.getItem();
                game.selectedObject.getPiece().setAvailableMoves(game.selectedObject.getPiece().getAvailableMoves() - 1);

                if(rp.getInventory().addObject(item)) {
                    tile.setItem(null);
                    rp.addValor(50);
                    TemporalPanel.addMessage("Item collected : "+item.getName());
                } else {
                    TemporalPanel.addErrorMessage("Inventory is full!");
                }
            }

            @Override
            public boolean isExecutable() {
                if(game.getCurrentPlayer().isRegularPlayer() && game.selectedObject != null && game.selectedObject.isPiece() && game.selectedObject.getPiece().getAvailableMoves() >= 1)  {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    Piece piece = game.selectedObject.getPiece();
                    return piece.getAlliance().equals(rp.getAlliance()) && game.getWorld().getPiecesOnWorld().get(piece).tileHasItem();
                }
                return false;
            }
        };
    }
    
    public static Action DrawCard(final Game game) {
        return new Action(game) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Can't draw card!");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                rp.drawCard();
            }

            @Override
            public boolean isExecutable() {
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    return rp.getDeck().getSize() > 0;
                }
                return false;
            }
            
        };
        
    }
    
    public static Action EndTurn(final Game game) {
        return new Action(game) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    return;
                }
                game.setCurrentPlayer(game.getNextPlayer());
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    DrawCard(game).execute();
                    rp.addValor(200);
                    game.getGameCamera().centerOnPiece(rp.getKing());
                    game.getWorld().getCloneList().stream().filter(tile -> tile.isTileOccupied() && tile.getPiece().getAlliance().equals(rp.getAlliance())).forEach(tile -> tile.getPiece().setAvailableMoves(tile.getPiece().getMoves()));
                    if(!rp.getAlliance().equals(Alliance.ALLIANCE_1)) {
                        AIManager.PlayAIManager(game, rp);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayableAction.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            @Override
            public boolean isExecutable() {
                return true;
            }
        };
    }
    
    public static ActionOnTile MovePiece(final Game game, final Tile tile) {
        return new ActionOnTile(game,tile) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Can't move piece");
                    return;
                }
                Piece movingPiece = game.selectedObject.getPiece();
                Tile sourceTile = game.getWorld().getPiecesOnWorld().get(movingPiece);
                int distanceFromSouceTile = (int)tile.getDistance();
                sourceTile.setPiece(null);
                tile.setPiece(movingPiece);
                game.getWorld().getCloneList().forEach(worldTile -> worldTile.resetDijkstra());
                game.getWorld().calculateShortestPathFromSource(tile);
                movingPiece.setAvailableMoves(movingPiece.getAvailableMoves() - distanceFromSouceTile);
                game.getWorld().getTilesAround(tile).forEach(tileAround -> game.getCurrentPlayer().getVision().addTile(tileAround));
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    if(!rp.getDeployTiles().contains(tile)) {
                        rp.getDeployTiles().addTile(tile);
                    }
                    game.getAllPlayers().stream().filter(player -> player.isRegularPlayer()).forEach(player -> {
                        RegularPlayer regPlayer = (RegularPlayer)player;
                        if(regPlayer != game.getCurrentPlayer() && regPlayer.getDeployTiles().contains(tile)) {
                                regPlayer.getDeployTiles().removeTile(tile);
                            }
                    });
                }
            }

            @Override
            public boolean isExecutable() {
                if(game.selectedObject != null && game.selectedObject.isPiece()) {
                    Piece piece = game.selectedObject.getPiece();
                    if(game.getCurrentPlayer().getVision().contains(tile) && piece.getAlliance().equals(game.getCurrentPlayer().getAlliance()) && 
                            !tile.isTileOccupied() && piece.getAvailableMoves() >= tile.getDistance() && !tile.equals(game.getWorld().getPiecesOnWorld().get(game.selectedObject.getPiece()))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
    public static ActionOnTile UseCard(final Game game, final Tile tile) {
        return new ActionOnTile(game,tile) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Can't summon piece");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Card card = game.selectedObject.getCard();
                Piece piece = new Piece(card.getSummonPiece());
                piece.setAvailableMoves(0);
                piece.setAlliance(rp.getAlliance());
                
                rp.addValor(card.getCost()*-1);
                rp.getHand().removeObject(card);
                tile.setPiece(piece);
                game.selectedObject = null;
                game.getWorld().getTilesAround(tile).forEach(tileAround -> rp.getVision().addTile(tileAround));
                game.getGameCamera().centerOnPiece(piece);
            }

            @Override
            public boolean isExecutable() {
                if(game.getCurrentPlayer().isRegularPlayer() && game.selectedObject != null && game.selectedObject.isCard()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    Card sc = game.selectedObject.getCard();
                    return rp.getDeployTiles().contains(tile) && rp.getValor() >= sc.getCost();
                }
                return false;
            }
        };
    }
    
    public static ActionOnPiece UseItem(final Game game, final Piece piece) {
        return new ActionOnPiece(game, piece) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Can't use item");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Item item = game.selectedObject.getItem();
                piece.getStats().addMod(item);
                rp.getInventory().removeObject(item); 
            }

            @Override
            public boolean isExecutable() {
                if(game.getCurrentPlayer().isRegularPlayer() && game.selectedObject != null && game.selectedObject.isItem()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    return game.selectedObject != null && game.selectedObject.isItem() && rp.getAlliance().equals(piece.getAlliance());
                }
                return false;
            }
        };
    }
    
    public static ActionOnPiece Attack(final Game game, final Piece targetPiece) {
        return new ActionOnPiece(game, targetPiece) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Can't attack");
                    return;
                }
                
                int p_x = game.getWorld().getPiecesOnWorld().get(targetPiece).getCoordinate_x()*Tile.TILE_WIDTH - Tile.TILE_WIDTH/2;
                int p_y = game.getWorld().getPiecesOnWorld().get(targetPiece).getCoordinate_y()*Tile.TILE_HEIGHT - Tile.TILE_HEIGHT/2;
                
                SpriteAnimation anim = new SpriteAnimation(Assets.SLASH);
                anim.setSize(Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2);
                game.getAnimationManager().addObject(anim, new Point(p_x, p_y));
                anim.start();
                
                Piece attaker = game.selectedObject.getPiece();
                float realArmor = targetPiece.getStats().getRealArmor() - attaker.getStats().getRealArmorPenetration();
                if(realArmor < 0) realArmor = 0;
                float amt = attaker.getDamage();
                if(realArmor < 90) {
                    amt -= amt*realArmor/100;
                } else {
                    amt -= amt*90/100;
                }
                
                amt += attaker.getElementalDamage();
                if(targetPiece.getElementalArmor() < 90) {
                    amt -= amt*targetPiece.getElementalArmor()/100;
                } else {
                    amt-= amt*90/100;
                }
                
                if(targetPiece.getElement().isWeakTo().equals(attaker.getElement())) {
                    amt *= 2;
                } else if(targetPiece.getElement().isResistantTo().equals(attaker.getElement())) {
                    amt = (amt*7)/10;
                }
                
                Random rand = new Random();
                
                if(rand.nextInt(100) <= attaker.getStats().getRealCritChance()) {
                    amt *= 2;
                } else if(rand.nextInt(100) <= targetPiece.getStats().getRealBlockChance()) {
                    amt = 0;
                }
                
                float lifeSteal = amt*attaker.getStats().getRealLifeSteal()/100;
                if(targetPiece.getStats().getHealth().getValue() + lifeSteal > targetPiece.getStats().getHealth().getMaxValue()) {
                    targetPiece.getStats().getHealth().setValue(targetPiece.getStats().getHealth().getMaxValue());
                } else {
                    attaker.getStats().getHealth().sumValue(lifeSteal);
                }
                targetPiece.getStats().getHealth().substractValue(amt); 
                attaker.setAvailableMoves(0);
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    rp.addValor(25);
                }
                TemporalPanel.addMessage("Attack damages : "+amt);
                if(targetPiece.getStats().health.getValue() <= 0) {
                    game.getWorld().getPiecesOnWorld().get(targetPiece).setPiece(null);
                    if(game.getCurrentPlayer().isRegularPlayer()) {
                        RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                        rp.addValor(150);
                    } 
                }
            }

            @Override
            public boolean isExecutable() {
                if(game.selectedObject != null && game.selectedObject.isPiece()) {
                    Piece attaker = game.selectedObject.getPiece();
                    if(attaker.getAlliance().equals(game.getCurrentPlayer().getAlliance()) && 
                            attaker.getAvailableMoves() > 0 && game.getWorld().getTilesAround(game.getWorld().getPiecesOnWorld().get(attaker)).contains(game.getWorld().getPiecesOnWorld().get(targetPiece))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
}
