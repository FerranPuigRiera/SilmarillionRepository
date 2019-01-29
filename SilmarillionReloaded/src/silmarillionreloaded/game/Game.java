/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import silmarillionreloaded.Application;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.entity.actions.EndTurn;
import silmarillionreloaded.gfx.GameCamera;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.worlds.World;
import userInterface.PieceInfoPanel;
import userInterface.UIManager;

/**
 *
 * @author Ferran
 */
public class Game {
    
    //public static PieceInfoPanel pieceInfoPanel; 
    
    public static void showInfoPanel(final Piece piece) {
        System.out.println("HI");
        float x = piece.getX() + piece.getWidth() + 5;
        float y = piece.getY() - 5;
        int width = 100;
        int height = 100;
        //pieceInfoPanel = new PieceInfoPanel(piece,x,y,width,height);
    }
    
    public static void hideInfoPanel() {
        //pieceInfoPanel = null;
    }
    
    private final Application app;
    
    private final ArrayList<Player> players;
    private final World world;
    private Player currentPlayer;
    private final UIManager uiManager;
    private final EndTurn endTurn;
    private final GameCamera gameCamera;
    
    public Game(Application app) {
        this.app = app;
        Piece.init();
        Card.init();
        Settings.init(this);
        
        uiManager = new UIManager();
        //uiManager.addObject(pieceInfoPanel);
        players = Settings.PLAYERS;
        currentPlayer = players.get(0);
        world = Settings.WORLD;
        gameCamera = new GameCamera(0,0);
        endTurn = new EndTurn();
        //pieceInfoPanel = new PieceInfoPanel(Piece.PIECES_CACHE.get(0),0,0,0,0);
        app.getMouseManager().addGame(this);
    }
    
    
    public void tick() {
        world.tickList();
        currentPlayer.tick();
        uiManager.tickList();
        //pieceInfoPanel.tick();
    }
    
    public void render(Graphics g) {
        world.renderList(g);
        currentPlayer.render(g);
        uiManager.renderList(g);
        //pieceInfoPanel.render(g);
    }
    
    public UIManager getUIManager() {
        return uiManager;
    }
    
    public World getWorld() {
        return world;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
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
