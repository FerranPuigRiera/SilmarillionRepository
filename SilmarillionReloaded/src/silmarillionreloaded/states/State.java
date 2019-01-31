/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.states;

import java.awt.Graphics;
import silmarillionreloaded.Application;

/**
 *
 * @author Ferran
 */
public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state) {
        currentState = state;
    }
    
    public static State getState() {
        return currentState;
    }
    
    protected final Application app;
    
    public State(Application app) {
        this.app = app;
    }
    
    public abstract void render(Graphics g);
    public abstract void tick();
    
}
