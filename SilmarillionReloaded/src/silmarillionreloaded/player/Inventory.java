/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import silmarillionreloaded.Application;
import silmarillion.renderableObjects.ObjectManager;

/**
 *
 * @author Ferran
 */
public class Inventory extends ObjectManager<Item> {
    
    public static final int INVENTORY_X = 250;
    public static final int INVENTORY_Y = 400;
    public static final int INVENTORY_WIDTH = 300;
    public static final int INVENTORY_HEIGHT = 200;
    
    public static final int COLUMNS = 5;
    public static final int ROWS = 3;
    public static final int INVENTORY_MAX_SIZE = COLUMNS*ROWS;
    
    
    public Inventory() {
        super(INVENTORY_X, INVENTORY_Y, INVENTORY_WIDTH, INVENTORY_HEIGHT, COLUMNS, Item.ITEM_WIDTH, Item.ITEM_HEIGHT, INVENTORY_MAX_SIZE);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, width, height);
        g.setColor(Color.BLACK);
        for(int i = 0; i < INVENTORY_MAX_SIZE;i++) {
            g.drawRect((int)x + (i % columns)*Item.ITEM_WIDTH,(int)y + (i / columns)*Item.ITEM_HEIGHT, Item.ITEM_WIDTH, Item.ITEM_HEIGHT);
        }
    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("Click on inventory");
    }

    @Override
    public boolean showList() {
        return true;
    }
    
}
