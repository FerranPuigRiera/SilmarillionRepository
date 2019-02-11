/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import silmarillionreloaded.renderableObjects.ObjectManager;

/**
 *
 * @author Ferran
 */
public class Deck extends ObjectManager<Card>{

    public static Deck generateRandomDeck() {
        Deck deck = new Deck();
        for(int i = 0; i < MAX_CARDS_IN_DECK; i++) {
            deck.addObject(Card.createRandomSummonCard());
        }
        return deck;
    }
    
    public final static int MAX_CARDS_IN_DECK = 60;
     
    public Deck() {
        super(0,0,0,0,1,Card.CARD_WIDTH,Card.CARD_HEIGHT,MAX_CARDS_IN_DECK);
        setDefaultRenderPoints();
    }

    public void shuffle() {
        shuffleList();
    }
    
    public Card draw() {
        if(getSize() > 0) {
            Card card = get(0);
            removeObject(card);
            return card;
        }
        return null;
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g, float x, float y) {
    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("Click on deck");
    }

    @Override
    public boolean showList() {
        return false;
    }
    
    
}
