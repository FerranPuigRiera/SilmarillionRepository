/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class Deck {
    
    public final static int MAX_CARDS_IN_DECK = 60;
    
    private final List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card draw() {
        if(cards.size() > 0) {
            Card card = cards.get(0);
            cards.remove(card);
            return card;
        } else {
            return null;
        }
    }
    
    public void addCard(Card card){
        if(cards.size() < MAX_CARDS_IN_DECK) {
            cards.add(card);
        } else {
            System.err.println("Deck is full");
        }
        
    }
    public void removeCard(Card card) {
        cards.remove(card);
    }
    
}
