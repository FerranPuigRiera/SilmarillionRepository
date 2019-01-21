/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class Hand {
    
    public static final int MAX_CARDS_IN_HAND = 10;
    
    public final List<Card> cards;
    
    public Hand() {
        cards = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        if(cards.size() < MAX_CARDS_IN_HAND) {
            cards.add(card);
        } else {
            System.err.println("Hand is full");
        }
        
    }
    
    public void removeCard(Card card) {
        cards.remove(card);
    }
    
}
