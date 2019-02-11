/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import silmarillionreloaded.renderableObjects.Panel.CardPanel;
import silmarillionreloaded.renderableObjects.RenderableObject;
import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.pieces.Element;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.game.ObjectSelected;
import silmarillionreloaded.gfx.Assets;

/**
 *
 * @author Ferran
 */
public class Card extends RenderableObject implements ObjectSelected{
    
    public static Card createNewSummonCard(int index) {
        return new Card(CARDS_CACHE.get(index));
    }
    
    
    private static final List<Card> CARDS_CACHE = new ArrayList<>();
    
    
    
    public static Card createRandomSummonCard() {
        Random r = new Random();
        int index = r.nextInt(CARDS_CACHE.size() - 1);
        return new Card(CARDS_CACHE.get(index));
    }
    
    public static void init() {
        
        //FIX ME!!!

        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(0),Assets.CARD_0001));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(1),Assets.CARD_0002));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(2),Assets.CARD_0003));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(3),Assets.CARD_0004));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(4),Assets.CARD_0005));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(5),Assets.CARD_0005));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(6),Assets.CARD_0007));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(7),Assets.CARD_0008));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(8),Assets.CARD_0009));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(9),Assets.CARD_0010));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(10),Assets.CARD_0011));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(11),Assets.CARD_0012));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(12),Assets.CARD_0013));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(13),Assets.CARD_0014));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(14),Assets.CARD_0015));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(15),Assets.CARD_0016));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(16),Assets.CARD_0020));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(17),Assets.CARD_0021));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(18),Assets.CARD_0022));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(19),Assets.CARD_0023));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(20),Assets.CARD_0024));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(21),Assets.CARD_0025));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(22),Assets.CARD_0026));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(23),Assets.CARD_0027));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(24),Assets.CARD_0028));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(25),Assets.CARD_0028));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(26),Assets.CARD_0029));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(27),Assets.CARD_0030));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(28),Assets.CARD_0031));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(29),Assets.CARD_0032));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(30),Assets.CARD_0033));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(31),Assets.CARD_0034));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(32),Assets.CARD_0037));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(33),Assets.CARD_0038));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(34),Assets.CARD_0039));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(35),Assets.CARD_0040));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(36),Assets.CARD_0041));
        CARDS_CACHE.add(new Card(Piece.PIECES_CACHE.get(37),Assets.CARD_0042));
        //FIX ME!!!
    }
    
    public static int CARD_WIDTH = Hand.HAND_WIDTH / Hand.MAX_CARDS_IN_HAND;
    public static int CARD_HEIGHT = Hand.HAND_HEIGHT;
    
    protected final String name;
    private final Piece summonPiece;
    private final Element element;
    private final int cost;
    protected final BufferedImage image;
    
    private Card(Piece piece, BufferedImage image) {
        super(CARD_WIDTH,CARD_HEIGHT);
        this.name = piece.getName();
        this.summonPiece = piece;
        this.cost = piece.calculateCost();
        this.element = piece.getElement();
        this.image = image;
    }
    
    private Card(Card card) {
        super(CARD_WIDTH,CARD_HEIGHT);
        name = card.name;
        summonPiece = card.summonPiece;
        cost = card.cost;
        element = card.element;
        image = card.image;
    }
    public String getName() {
        return name;
    }

    public Piece getSummonPiece() {
        return summonPiece;
    }
    
    public int getCost() {
        return cost;
    }

    public Element getElement() {
        return element;
    }
    
    
    
    @Override
    public void onClick(MouseEvent e) {
        Game.INSTANCE.selectedObject = this;
        Game.INSTANCE.getPanelManager().addObject(new TemporalPanel(
                    new CardPanel(this,e.getX(),e.getY(),140, 80),1500));
        
        
    }

    @Override
    public boolean isCard() {
        return true;
    }

    @Override
    public boolean isPiece() {
        return false;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public Card getCard() {
        return this;
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
        if(Game.INSTANCE.selectedObject!= null && Game.INSTANCE.selectedObject.equals(this)) {
            g.setColor(Color.GREEN);
            g.drawRect((int)x, (int)y, width-1, height-1);
        }
        
    }
    
    
}
