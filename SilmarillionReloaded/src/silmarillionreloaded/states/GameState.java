/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.states;

import java.awt.Graphics;
import silmarillionreloaded.Application;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class GameState extends State{

    
    private World world;
    
    public GameState(Application app) {
        super(app);
        world = new World(app,"");
    }
    
    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    @Override
    public void tick() {
        world.tick();
    }
    
}
