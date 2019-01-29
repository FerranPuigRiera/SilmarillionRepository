/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import silmarillionreloaded.ObjectManager;

/**
 *
 * @author Ferran
 */
public class Inventory extends ObjectManager<Item> {
    
    public static final int INVENTORY_X = 50;
    public static final int INVENTORY_Y = 400;
    public static final int INVENTORY_WIDTH = 300;
    public static final int INVENTORY_HEIGHT = 200;

    public static final int INVENTORY_MAX_SIZE = 15;
    
    
    public Inventory() {
        super(INVENTORY_X, INVENTORY_Y, INVENTORY_WIDTH, INVENTORY_HEIGHT, INVENTORY_MAX_SIZE);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void onClick() {
        System.out.println("Click on inventory");
    }
    
}
