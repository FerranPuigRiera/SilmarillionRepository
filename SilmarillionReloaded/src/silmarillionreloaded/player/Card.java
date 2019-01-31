/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import silmarillion.renderableObjects.Panel.CardPanel;
import silmarillion.renderableObjects.RenderableObject;
import silmarillion.renderableObjects.TemporalPanel;
import silmarillionreloaded.pieces.Element;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.actions.Spell;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;

/**
 *
 * @author Ferran
 */
public abstract class Card extends RenderableObject{
    
    public static Card SELECTED_CARD;
    
    public static SummonCard createNewSummonCard(int index) {
        try {
            return (SummonCard)SUMMON_CARDS_CACHE.get(index).clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    private static final List<SummonCard> SUMMON_CARDS_CACHE = new ArrayList<>();
    
    public static SummonCard createRandomSummonCard() {
        Random r = new Random();
        int index = r.nextInt(SUMMON_CARDS_CACHE.size() - 1);
        return new SummonCard(SUMMON_CARDS_CACHE.get(index));
    }
    
    public static void init() {
        //FIX ME!!!
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(0),Assets.CARD_0000));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(1),Assets.CARD_0001));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(2),Assets.CARD_0002));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(3),Assets.CARD_0003));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(4),Assets.CARD_0004));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(5),Assets.CARD_0005));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(6),Assets.CARD_0005));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(7),Assets.CARD_0007));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(8),Assets.CARD_0008));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(9),Assets.CARD_0009));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(10),Assets.CARD_0010));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(11),Assets.CARD_0011));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(12),Assets.CARD_0012));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(13),Assets.CARD_0013));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(14),Assets.CARD_0014));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(15),Assets.CARD_0015));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(16),Assets.CARD_0016));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(17),Assets.CARD_0021));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(18),Assets.CARD_0022));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(19),Assets.CARD_0023));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(20),Assets.CARD_0024));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(21),Assets.CARD_0025));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(22),Assets.CARD_0026));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(23),Assets.CARD_0027));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(24),Assets.CARD_0028));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(25),Assets.CARD_0031));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(26),Assets.CARD_0032));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(27),Assets.CARD_0033));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(28),Assets.CARD_0034));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(29),Assets.CARD_0035));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(30),Assets.CARD_0032));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(31),Assets.CARD_0033));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(32),Assets.CARD_0034));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(33),Assets.CARD_0037));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(34),Assets.CARD_0038));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(35),Assets.CARD_0039));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(36),Assets.CARD_0040));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(37),Assets.CARD_0041));
        SUMMON_CARDS_CACHE.add(new SummonCard(Piece.PIECES_CACHE.get(38),Assets.CARD_0042));
        //FIX ME!!!
    }
    
    public static int CARD_WIDTH = Hand.HAND_WIDTH / Hand.MAX_CARDS_IN_HAND;
    public static int CARD_HEIGHT = Hand.HAND_HEIGHT;
    
    protected final String name;
    protected final int cost;
    protected final Element element;
    protected final BufferedImage image;
    
    
    private Card(String name, int cost, Element element, BufferedImage image) {
        super(CARD_WIDTH,CARD_HEIGHT);
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.cost;
        hash = 29 * hash + Objects.hashCode(this.element);
        hash = 29 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        
        
        return true;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Element getElement() {
        return element;
    }
    
    
    
    @Override
    public void onClick(MouseEvent e) {
        if(SELECTED_CARD != this) {
            SELECTED_CARD = this;
            Game.INSTANCE.getPanelManager().addObject(new TemporalPanel(
                    new CardPanel(this,e.getX(),e.getY(),140, 80),1500));
        }
        
    }
    
    
    public static class SummonCard extends Card{
        
        private final Piece piece;
        
        public SummonCard(Piece piece, BufferedImage image) {
            super(piece.getName(),piece.calculateCost(),piece.getElement(),image);
            this.piece = piece;
        }    
        
        private SummonCard(SummonCard card) {
            super(card.piece.getName(),card.piece.calculateCost(), card.piece.getElement(),card.image);
            piece = card.piece;
        }
        
        
        @Override
        public void tick() {
            
        }

        @Override
        public void render(Graphics g, float x, float y) {
            g.drawImage(image, (int)x, (int)y, width, height, null);
        }

        

        
    }
    
    public static class SpellCard extends Card {
        
        private final Spell spell;
        
        public SpellCard(String name, Spell spell, int cost, Element element, BufferedImage image) {
            super(name, cost, element, image);
            this.spell = spell;
        }

        @Override
        public void tick() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void render(Graphics g, float x, float y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onClick(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
        
    }
    
    public static class ItemCard extends Card {
        
        private final Item item;
        
        public ItemCard(String name, Item item, int cost, Element element, BufferedImage image) {
            super(name, cost, element, image);
            this.item = item;
        }

        @Override
        public void tick() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void render(Graphics g, float x, float y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onClick(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        
        
    }
    
}
