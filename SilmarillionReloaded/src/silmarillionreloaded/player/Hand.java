/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import silmarillionreloaded.renderableObjects.ObjectManager;

/**
 *
 * @author Ferran
 */
public class Hand extends ObjectManager<Card>{
    
    public static final int MAX_CARDS_IN_HAND = 10;
    public static final int HAND_X = 350;
    public static final int HAND_Y = 750;
    public static final int HAND_WIDTH = 1000;
    public static final int HAND_HEIGHT = 200;


    public Hand() {
        super(HAND_X, HAND_Y, HAND_WIDTH, HAND_HEIGHT,10, Card.CARD_WIDTH, Card.CARD_HEIGHT, MAX_CARDS_IN_HAND);
        setDefaultRenderPoints();
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.setColor(Color.BLUE);
        g.drawRect((int)x, (int)y, width, height);
    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("Clicl on hand");
    }

    @Override
    public boolean showList() {
        return true;
    }
    
    
    
    
}
