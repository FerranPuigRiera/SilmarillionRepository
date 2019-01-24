/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.states;

import java.awt.Graphics;
import silmarillionreloaded.Application;
import userInterface.UIManager;

/**
 *
 * @author Ferran
 */
public class MenuState extends State{
    
    private UIManager uiManager;
    
    public MenuState(Application app) {
        super(app);
        uiManager = new UIManager(app);
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void tick() {
    }

    @Override
    public UIManager getUIManager() {
        return uiManager;
    }
    
}
