/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.image.BufferedImage;
import silmarillionreloaded.entity.Element;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.entity.actions.DeployPiece;
import silmarillionreloaded.entity.actions.Spell;
import silmarillionreloaded.game.Game;

/**
 *
 * @author Ferran
 */
public abstract class Card {
    
    protected final String name;
    protected final int cost;
    protected final Element element;
    protected final BufferedImage image;
    
    
    public Card(String name, int cost, Element element, BufferedImage image) {
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.image = image;
    }
    
    
    
    public static class SummonCard extends Card{
        
        private final Piece piece;
        
        public SummonCard(String name, Piece piece,int cost, Element element, BufferedImage image) {
            super(name,cost,element,image);
            this.piece = piece;
        }        
    }
    
    public static class SpellCard extends Card {
        
        private final Spell spell;
        
        public SpellCard(String name, Spell spell, int cost, Element element, BufferedImage image) {
            super(name, cost, element, image);
            this.spell = spell;
        }
        
    }
    
    public static class ItemCard extends Card {
        
        private final Item item;
        
        public ItemCard(String name, Item item, int cost, Element element, BufferedImage image) {
            super(name, cost, element, image);
            this.item = item;
        }
        
    }
    
}
