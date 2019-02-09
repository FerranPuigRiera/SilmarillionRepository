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
import silmarillion.renderableObjects.Button;
import silmarillion.renderableObjects.PanelManager;
import silmarillion.userInterface.Clicker;
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
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public final class Game {

    public static Game INSTANCE;
    
    

    
    public Player getNextPlayer() {
        Player firstPlayer = getAllPlayers().get(0);
        Iterator<Player> players = getAllPlayers().iterator();
        while(players.hasNext()) {
            Player player = players.next();
            if(player.equals(currentPlayer)) {
                if(players.hasNext()) {
                    return players.next();
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
    
    
    public Game(Application app) {
        INSTANCE = this;
        this.app = app;
        PlayableAction.init(this);
        Piece.init();
        Card.init();
        Item.init();
        Settings.init(this);
        players = Settings.PLAYERS;
        
        currentPlayer = players.get(0);
        world = Settings.WORLD;
        gameCamera = new GameCamera(0,0);
        if(currentPlayer.isRegularPlayer()) {
            RegularPlayer rp = (RegularPlayer)currentPlayer;
            gameCamera.centerOnPiece(rp.getKing());
        }
        
        panelManager = new PanelManager();
        players.stream().filter(player -> player.isRegularPlayer()).forEach(player -> {
            RegularPlayer rp = (RegularPlayer)player;
            rp.initDeployCoordinates();
        });
        Application.MOUSE_MANAGER.addGame(this);
        BufferedImage[] endTurnButtonImages = new BufferedImage[2];
        endTurnButtonImages[0] = Assets.END_TURN_B;
        endTurnButtonImages[1] = Assets.END_TURN_H;
        endTurnButton = new Button(120, 60,endTurnButtonImages , new Clicker() {
            @Override
            public void onClick() {
                PlayableAction.END_TURN.execute();
            }
        });
        BufferedImage[] collectButtonImages = new BufferedImage[2];
        collectButtonImages[0] = Assets.COLLECT_B;
        collectButtonImages[1] = Assets.COLLECT_H;
        collectButton = new Button(120, 60, collectButtonImages, new Clicker() {
            @Override
            public void onClick() {
                PlayableAction.COLLECT_ITEM.execute();
            }
        });
        players.stream().filter(player -> player.isRegularPlayer()).forEach(player -> {
            RegularPlayer rp = (RegularPlayer)player;
            Tile kingTile = world.findTilesPieceOnWorld(rp.getKing());
            rp.getVision().addTile(kingTile);
            world.getTilesAround(kingTile).forEach(tileAround -> rp.getVision().addTile(tileAround));
        });
        
    }
    
    
    public void tick() {
        
        Rectangle outerRect = new Rectangle(0,0,world.getWidth(),world.getHeight());
        Rectangle innerRect = new Rectangle(world.getWidth()/4,world.getHeight()/4,world.getWidth()/2,world.getHeight()/2);
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
                Game.INSTANCE.getGameCamera().move(-1, 0);
            } else if(mm.getMouseX() > innerRect.x + innerRect.width) {
                Game.INSTANCE.getGameCamera().move(1, 0);
            }
            if(mm.getMouseY() < innerRect.y) {
                Game.INSTANCE.getGameCamera().move(0, -1);
            } else if(mm.getMouseY() > innerRect.y + innerRect.height) {
                Game.INSTANCE.getGameCamera().move(0, 1);
            }
            
            
        }
        
        world.tick();
        world.tickList();
        currentPlayer.tick();
        panelManager.tickList();
        endTurnButton.tick();
        collectButton.tick();
    }
    
    public void render(Graphics g) {
        g.drawImage(Assets.GAME_BACKGROUND_1,0,0, Application.FRAME_WIDTH, Application.FRAME_HEIGHT, null);
        world.renderList(g);
        currentPlayer.render(g, Player.PLAYER_X, Player.PLAYER_Y);
        panelManager.renderList(g);
        endTurnButton.render(g, 1500, 800);
        if(PlayableAction.COLLECT_ITEM.isExecutable()) {
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
