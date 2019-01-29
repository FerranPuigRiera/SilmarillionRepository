/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import silmarillionreloaded.RenderableObject;

/**
 *
 * @author Ferran
 */
public class Item extends RenderableObject {
    
    private BufferedImage image;
    
    public Item(int width, int height, BufferedImage image) {
        super(width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    @Override
    public void onClick() {
        System.out.println("Clicking item");
    }

   
    
}
