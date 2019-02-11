/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import silmarillionreloaded.userInterface.Clicker;

/**
 *
 * @author Ferran
 */
public class Button extends RenderableObject {

    private final BufferedImage[] images;
    private final Clicker clicker;
    private int renderingImage = 0;
    
    public Button(int width, int height, BufferedImage[] images, Clicker clicker) {
        super(width,height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {
        if(hovering) {
            renderingImage = 1;
        } else {
            renderingImage = 0;
        }
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.drawImage(images[renderingImage], (int) x, (int) y, width, height, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        clicker.onClick();
    }
    
}
