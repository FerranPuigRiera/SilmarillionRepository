/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import silmarillionreloaded.Application;

/**
 *
 * @author Ferran
 */
public class MenuState extends State{
    
    
    
    
    
    public MenuState(Application app) {
        super(app);
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.black);
        g.drawString("Hola a Tothom :)", Application.FRAME_WIDTH / 2 - 150, Application.FRAME_HEIGHT / 2 + 20);
        
    }

    @Override
    public void tick() {
    }
    
}
