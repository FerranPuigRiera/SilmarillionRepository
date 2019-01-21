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
import silmarillionreloaded.entity.actions.EndTurn;
import silmarillionreloaded.gfx.GameCamera;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class Game {
    
    private final ArrayList<Player> players;
    private final World world;
    private Player currentPlayer;
    private final EndTurn endTurn;
    private final GameCamera gameCamera;
    
    public Game() {
        Settings.init(this);
        players = Settings.PLAYERS;
        currentPlayer = players.get(0);
        world = Settings.WORLD;
        gameCamera = new GameCamera(0,0);
        endTurn = new EndTurn();
    }
    
    
    public void tick() {
        world.tick();
    }
    
    public void render(Graphics g) {
        world.render(g);
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
