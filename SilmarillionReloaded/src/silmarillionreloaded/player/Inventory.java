/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.renderableObjects.ObjectManager;

/**
 *
 * @author Ferran
 */
public class Inventory extends ObjectManager<Item> {
    
    public static final int COLUMNS = 8;
    public static final int ROWS = 5;
    
    public static final int INVENTORY_X = 25;
    public static final int INVENTORY_Y = 750;
    public static final int INVENTORY_WIDTH = COLUMNS*Item.ITEM_WIDTH;
    public static final int INVENTORY_HEIGHT = ROWS*Item.ITEM_HEIGHT;
    
    
    public static final int INVENTORY_MAX_SIZE = COLUMNS*ROWS;
    
    
    private final Game game;
    
    public Inventory(final Game game) {
        super(INVENTORY_X, INVENTORY_Y, INVENTORY_WIDTH, INVENTORY_HEIGHT, COLUMNS, Item.ITEM_WIDTH, Item.ITEM_HEIGHT, INVENTORY_MAX_SIZE);
        this.game = game;
        setDefaultRenderPoints();
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, width, height);
        g.setColor(Color.BLACK);
        for(int i = 0; i < INVENTORY_MAX_SIZE;i++) {
            int x_coord = i % COLUMNS;
            int y_coord = i / COLUMNS;
            int print_x = (int)x + x_coord*Item.ITEM_WIDTH;
            int print_y = (int)y + y_coord*Item.ITEM_HEIGHT;
            g.drawRect(print_x,print_y, Item.ITEM_WIDTH, Item.ITEM_HEIGHT);
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
