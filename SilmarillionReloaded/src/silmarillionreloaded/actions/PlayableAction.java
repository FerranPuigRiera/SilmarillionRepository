/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player.RegularPlayer;
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
    
    public static abstract class ActionOnTile extends PlayableAction {
        
        public ActionOnTile(Game game) {
            super(game);
        }
        
        public abstract void execute(Tile tile);
        public abstract boolean isExecutable(Tile tile);
        
    }
    public static abstract class ActionOnPiece extends PlayableAction {
        
        public ActionOnPiece(Game game) {
            super(game);
        }
        
        public abstract void execute(Piece piece);
        public abstract boolean isExecutable(Piece piece);
        
    }
    public static abstract class Action extends PlayableAction {
        
        public Action(Game game) {
            super(game);
        }
        
        public abstract void execute();
        public abstract boolean isExecutable();
        
    }
    
    public static Action COLLECT_ITEM, DRAW_CARD, END_TURN;
    public static ActionOnTile MOVE_PIECE, USE_SUMMON_CARD;
    public static ActionOnPiece USE_ITEM, ATTACK, ATTACK_ELEMENTAL, HEAL, ON_GUARD;
    
    public static void init(final Game game) {
        
        COLLECT_ITEM = new Action(game) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    TemporalPanel.addErrorMessage("Cant collect item!");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Tile tile = game.getWorld().findTilesPieceOnWorld(game.selectedObject.getPiece());
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
                    return piece.getAlliance().equals(rp.getAlliance()) && game.getWorld().findTilesPieceOnWorld(piece).tileHasItem();
                }
                return false;
            }
        };
        
       
        DRAW_CARD = new Action(game) {
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
        END_TURN = new Action(game) {
            @Override
            public void execute() {
                if(!isExecutable()) {
                    return;
                }
                game.setCurrentPlayer(game.getNextPlayer());
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    DRAW_CARD.execute();
                    rp.addValor(200);
                    game.getGameCamera().centerOnPiece(rp.getKing());
                    game.getWorld().getCloneList().stream().filter(tile -> tile.isTileOccupied() && tile.getPiece().getAlliance().equals(rp.getAlliance())).forEach(tile -> tile.getPiece().setAvailableMoves(tile.getPiece().getMoves()));
                }
            }

            @Override
            public boolean isExecutable() {
                return true;
            }
        };
        
        MOVE_PIECE = new ActionOnTile(game) {
            @Override
            public void execute(Tile tile) {
                
                if(!isExecutable(tile)) {
                    TemporalPanel.addErrorMessage("Can't move piece");
                    return;
                }
                Piece movingPiece = game.selectedObject.getPiece();
                Tile sourceTile = game.getWorld().findTilesPieceOnWorld(movingPiece);
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
                        if(regPlayer != Game.INSTANCE.getCurrentPlayer() && regPlayer.getDeployTiles().contains(tile)) {
                                regPlayer.getDeployTiles().removeTile(tile);
                            }
                    });
                }
            }

            @Override
            public boolean isExecutable(Tile tile) {
                if(game.selectedObject != null && game.selectedObject.isPiece()) {
                    Piece piece = game.selectedObject.getPiece();
                    if(game.getCurrentPlayer().getVision().contains(tile) && piece.getAlliance().equals(game.getCurrentPlayer().getAlliance()) && !tile.isTileOccupied() && piece.getAvailableMoves() >= tile.getDistance()) {
                        return true;
                    }
                }
                return false;
            }
        };
        
        USE_SUMMON_CARD = new ActionOnTile(game) {
            @Override
            public void execute(Tile tile) {
                if(!isExecutable(tile)) {
                    TemporalPanel.addErrorMessage("Can't summon piece");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Card card = game.selectedObject.getCard();
                Piece piece = Piece.createNewPiece(Piece.PIECES_CACHE.indexOf(game.selectedObject.getCard().getSummonPiece()), rp.getAlliance());
                piece.setAvailableMoves(0);
                rp.addValor(card.getCost()*-1);
                rp.getHand().removeObject(card);
                tile.setPiece(piece);
                game.selectedObject = null;
                game.getWorld().getTilesAround(tile).forEach(tileAround -> rp.getVision().addTile(tileAround));
            }

            @Override
            public boolean isExecutable(Tile tile) {
          
                if(game.getCurrentPlayer().isRegularPlayer() && game.selectedObject != null && game.selectedObject.isCard()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    Card sc = game.selectedObject.getCard();
                    return rp.getDeployTiles().contains(tile) && rp.getValor() >= sc.getCost();
                }
                return false;
            }
        };
        
        USE_ITEM = new ActionOnPiece(game) {
            @Override
            public void execute(Piece piece) {
                if(!isExecutable(piece)) {
                    TemporalPanel.addErrorMessage("Can't use item");
                    return;
                }
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                Item item = game.selectedObject.getItem();
                piece.getStats().addMod(item);
                rp.getInventory().removeObject(item);   
            }

            @Override
            public boolean isExecutable(Piece piece) {
                if(game.getCurrentPlayer().isRegularPlayer() && game.selectedObject != null && game.selectedObject.isItem()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    return game.selectedObject != null && game.selectedObject.isItem() && rp.getAlliance().equals(piece.getAlliance());
                }
                return false;
            }
        };
        
        ATTACK = new ActionOnPiece(game) {
            @Override
            public void execute(Piece piece) {
                if(!isExecutable(piece)) {
                    TemporalPanel.addErrorMessage("Can't attack");
                    return;
                }
                Piece attaker = game.selectedObject.getPiece();
                int amt = attaker.getDamage();
                if(piece.getArmor() < 90) {
                    amt -= amt*piece.getArmor()/100;
                } else {
                    amt -= amt*90/100;
                }
                
                amt += attaker.getElementalDamage();
                if(piece.getElementalArmor() < 90) {
                    amt -= amt*piece.getElementalArmor()/100;
                } else {
                    amt-= amt*90/100;
                }
                
                if(piece.getElement().isWeakTo().equals(attaker.getElement())) {
                    amt *= 2;
                } else if(piece.getElement().isResistantTo().equals(attaker.getElement())) {
                    amt = (amt*7)/10;
                }
                piece.getStats().health.substractValue(amt);
                attaker.setAvailableMoves(0);
                if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    rp.addValor(25);
                }
                TemporalPanel.addMessage("Attack damages : "+amt);
                if(piece.getStats().health.getValue() <= 0) {
                    game.getWorld().findTilesPieceOnWorld(piece).setPiece(null);
                    if(game.getCurrentPlayer().isRegularPlayer()) {
                    RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                    rp.addValor(150);
                }
                }
            }

            @Override
            public boolean isExecutable(Piece piece) {
                if(game.selectedObject != null && game.selectedObject.isPiece()) {
                    Piece attaker = game.selectedObject.getPiece();
                    if(attaker.getAlliance().equals(game.getCurrentPlayer().getAlliance()) && 
                            attaker.getAvailableMoves() > 0 && game.getWorld().getTilesAround(game.getWorld().findTilesPieceOnWorld(attaker)).contains(game.getWorld().findTilesPieceOnWorld(piece))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
}
