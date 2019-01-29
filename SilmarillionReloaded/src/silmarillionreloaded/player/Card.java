/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import silmarillionreloaded.RenderableObject;
import silmarillionreloaded.pieces.Element;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.entity.actions.Spell;
import silmarillionreloaded.gfx.Assets;

/**
 *
 * @author Ferran
 */
public abstract class Card extends RenderableObject{
    
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
        return SUMMON_CARDS_CACHE.get(r.nextInt(SUMMON_CARDS_CACHE.size()));
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
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.image = image;
    }
    
    public static class SummonCard extends Card{
        
        private final Piece piece;
        
        public SummonCard(Piece piece, BufferedImage image) {
            super(piece.getName(),piece.calculateCost(),piece.getElement(),image);
            this.piece = piece;
        }     
        @Override
        public void tick() {
            //bounds.setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        }

        @Override
        public void render(Graphics g) {
            g.drawImage(image, (int)x, (int)y, width, height, null);
        }

        

        @Override
        public void onClick() {
            System.err.println("Does notheing yet :( ");
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
        public void render(Graphics g) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onClick() {
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
        public void render(Graphics g) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onClick() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        
        
    }
    
}
