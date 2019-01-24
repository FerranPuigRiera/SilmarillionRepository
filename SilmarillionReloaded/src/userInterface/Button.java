/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ferran
 */
public class Button extends UIObject{

    private BufferedImage[] images;
    private Clicker clicker;
    
    public Button(float x, float y, int width, int height, BufferedImage[] images, Clicker clicker) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        if(hovering) {
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
    
    
    
}
