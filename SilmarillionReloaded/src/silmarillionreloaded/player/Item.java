/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import renderableObjects.RenderableObject;

/**
 *
 * @author Ferran
 */
public class Item extends RenderableObject {
    
    public final static int ITEM_WIDTH = Inventory.INVENTORY_WIDTH / Inventory.COLUMNS;
    public final static int ITEM_HEIGHT = Inventory.INVENTORY_HEIGHT / Inventory.ROWS ;
    
    private BufferedImage image;
    
    public Item(int width, int height, BufferedImage image) {
        super(width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("Clicking item");
    }

   
    
}
