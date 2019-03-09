/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import silmarillionreloaded.renderableObjects.Button;
import silmarillionreloaded.renderableObjects.PanelManager;
import silmarillionreloaded.Application;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.actions.PlayableAction;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.gfx.GameCamera;
import silmarillionreloaded.input.MouseManager;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.player.Player.RegularPlayer;
import silmarillionreloaded.renderableObjects.FreeObjectManager;
import silmarillionreloaded.renderableObjects.SpriteAnimation;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public final class Game {
    public static final int INITIAL_VALOR_FOR_PLAYER = 500;
    //public static Game INSTANCE;

    public Player getNextPlayer() {
        Player firstPlayer = getAllPlayers().get(0);
        Iterator<Player> playersIterator = getAllPlayers().iterator();
        while(playersIterator.hasNext()) {
            Player player = playersIterator.next();
            if(player.equals(currentPlayer)) {
                if(playersIterator.hasNext()) {
                    return playersIterator.next();
                } else {
                    return firstPlayer;
                }
            }
        }
        throw new RuntimeException("Player not found");
    }



    private final Application app;
    
    private final ArrayList<Player> players;
    private final World world;
    private Player currentPlayer;
    private final GameCamera gameCamera;
    private final PanelManager panelManager;
    private final Button endTurnButton;
    private final Button collectButton;
    public ObjectSelected selectedObject = null;
    
    private final FreeObjectManager<SpriteAnimation> animationManager;
    
    
    public Game(Application app) {
        this.app = app;
        
        Piece.init(this);
        Card.init(this);
        Item.init(this);
        
        world = new World(this);
        players = new ArrayList<>();
        players.add(Player.createNewRandomRegularPlayer(this, Alliance.ALLIANCE_1));
        players.add(Player.createNewRandomRegularPlayer(this, Alliance.ALLIANCE_2));
        players.add(Player.createNewRandomRegularPlayer(this, Alliance.ALLIANCE_3));
        Random r = new Random();
        players.stream().filter(player -> player.isRegularPlayer()).forEach(player -> {
            RegularPlayer rp = (RegularPlayer)player;
            rp.drawCard();
            rp.drawCard();
            rp.drawCard();
            rp.drawCard();
            int kingSpawn; 
            do {
                kingSpawn = r.nextInt(world.getColumns()*world.getRows());
            } while(world.get(kingSpawn).isTileOccupied());
            Tile kingTile = world.get(kingSpawn);
            kingTile.setPiece(rp.getKing());
            rp.getVision().addTile(kingTile);
            world.getTilesAround(kingTile).forEach(tileAround -> rp.getVision().addTile(tileAround));
            rp.initDeployCoordinates();
        });
        
        currentPlayer = players.get(0);
        gameCamera = new GameCamera(this,0,0);
        animationManager = new FreeObjectManager();
        animationManager.setCamera(gameCamera);
        if(currentPlayer.isRegularPlayer()) {
            RegularPlayer rp = (RegularPlayer)currentPlayer;
            gameCamera.centerOnPiece(rp.getKing());
        }
        
        panelManager = new PanelManager();
        Application.MOUSE_MANAGER.addGame(this);
        BufferedImage[] endTurnButtonImages = new BufferedImage[2];
        endTurnButtonImages[0] = Assets.END_TURN_B;
        endTurnButtonImages[1] = Assets.END_TURN_H;
        endTurnButton = new Button(120, 60,endTurnButtonImages , PlayableAction.EndTurn(this)::execute);
        BufferedImage[] collectButtonImages = new BufferedImage[2];
        collectButtonImages[0] = Assets.COLLECT_B;
        collectButtonImages[1] = Assets.COLLECT_H;
        collectButton = new Button(120, 60, collectButtonImages, PlayableAction.CollectItem(this)::execute);
    }
    
    
    public void tick() {
        
        Rectangle outerRect = new Rectangle(0,0,Application.FRAME_WIDTH,Application.FRAME_HEIGHT);
        Rectangle innerRect = new Rectangle(outerRect.width/4,outerRect.height/4,outerRect.width/2,outerRect.height/2);
        MouseManager mm = Application.MOUSE_MANAGER;
        boolean movingMap = true;
        if(currentPlayer.isRegularPlayer()) {
            RegularPlayer rp = (RegularPlayer)currentPlayer;
            if(rp.getInventory().isHovering() || rp.getHand().isHovering() || rp.isHovering()) {
                movingMap = false;
            }
        }
        if(movingMap && outerRect.contains(mm.getMouseX(), mm.getMouseY()) && 
           !innerRect.contains(mm.getMouseX(),mm.getMouseY())) {
            
            if(mm.getMouseX() < innerRect.x) {
                getGameCamera().move(-1, 0);
            } else if(mm.getMouseX() > innerRect.x + innerRect.width) {
                getGameCamera().move(1, 0);
            }
            if(mm.getMouseY() < innerRect.y) {
                getGameCamera().move(0, -1);
            } else if(mm.getMouseY() > innerRect.y + innerRect.height) {
                getGameCamera().move(0, 1);
            }
            
            
        }
        
        world.tick();
        world.tickList();
        animationManager.tickList();
        currentPlayer.tick();
        panelManager.tickList();
        endTurnButton.tick();
        collectButton.tick();
    }
    
    public void render(Graphics g) {
        g.drawImage(Assets.GAME_BACKGROUND_1,0,0, Application.FRAME_WIDTH, Application.FRAME_HEIGHT, null);
        world.renderList(g);
        animationManager.renderList(g);
        currentPlayer.render(g, Player.PLAYER_X, Player.PLAYER_Y);
        panelManager.renderList(g);
        endTurnButton.render(g, 1500, 800);
        if(PlayableAction.CollectItem(this).isExecutable()) {
            collectButton.render(g, 1500, 700);
        }
        
    }
    
    public Button getEndTurnButton() {
        return endTurnButton;
    }
    public Button getCollectButton() {
        return collectButton;
    }
    public World getWorld() {
        return world;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public FreeObjectManager getAnimationManager() {
        return animationManager;
    }
    
    public PanelManager getPanelManager() {
        return panelManager;
    }
    
    public void setCurrentPlayer(final Player player) {
        currentPlayer = player;
    }
    
    public List<Player> getAllPlayers() {
        return players;
    }
    
    public GameCamera getGameCamera() {
        return gameCamera;
    }

}
