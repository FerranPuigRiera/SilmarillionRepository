/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import silmarillion.renderableObjects.PanelManager;
import silmarillionreloaded.Application;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.actions.EndTurn;
import silmarillionreloaded.gfx.GameCamera;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class Game {

    public static Game INSTANCE;
    

    private final Application app;
    
    private final ArrayList<Player> players;
    private final World world;
    private Player currentPlayer;
    private final EndTurn endTurn;
    private final GameCamera gameCamera;
    private final PanelManager panelManager;
    
    public Game(Application app) {
        this.app = app;
        Piece.init();
        Card.init();
        Item.init();
        Settings.init(this);
        players = Settings.PLAYERS;
        currentPlayer = players.get(0);
        world = Settings.WORLD;
        gameCamera = new GameCamera(0,0);
        endTurn = new EndTurn();
        panelManager = new PanelManager();
        app.getMouseManager().addGame(this);
        INSTANCE = this;
    }
    
    
    public void tick() {
        world.tick();
        world.tickList();
        currentPlayer.tick();
        panelManager.tickList();
        //pieceInfoPanel.tick();
    }
    
    public void render(Graphics g) {
        world.renderList(g);
        currentPlayer.render(g, Player.PLAYER_X, Player.PLAYER_Y);
        panelManager.renderList(g);
        //pieceInfoPanel.render(g);
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
    
    public void endTurn() {
        endTurn.execute(this);
    }
    
    
}
