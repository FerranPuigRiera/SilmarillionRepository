/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.states;

import java.awt.Graphics;
import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;

/**
 *
 * @author Ferran
 */
public class GameState extends State{

    
    private Game game;
    
    public GameState(final Application app) {
        super(app);
        app.startGame();
        game = app.getGame();
    }
    
    @Override
    public void render(Graphics g) {
        game.render(g);
    }

    @Override
    public void tick() {
        game.tick();
    }
    
}
