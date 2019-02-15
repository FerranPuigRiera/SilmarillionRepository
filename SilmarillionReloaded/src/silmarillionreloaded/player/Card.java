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
    
    public static void init(final Game game) {

        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(0),Assets.CARD_0001));//Beren
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(1),Assets.CARD_0002));//Hurin
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(2),Assets.CARD_0003));//Eagle
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(3),Assets.CARD_0004));//Sindar elf
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(4),Assets.CARD_0005));//Numenorian
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(5),Assets.CARD_0006));//Huor
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(6),Assets.CARD_0007));//Tuor
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(7),Assets.CARD_0008));//Feanor
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(8),Assets.CARD_0009));//Fingolfin
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(9),Assets.CARD_0010));//Luthien
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(10),Assets.CARD_0011));//Manwe
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(11),Assets.CARD_0012));//Varda
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(12),Assets.CARD_0013));//Gondolin soldier
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(13),Assets.CARD_0014));//Doriah ranger
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(14),Assets.CARD_0015));//Noldor elf
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(15),Assets.CARD_0016));//Dwarf belegosy
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(16),Assets.CARD_0018));//Windor
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(17),Assets.CARD_0019));//Cirdan
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(18),Assets.CARD_0020));//Maedros
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(19),Assets.CARD_0021));//Morgoth
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(20),Assets.CARD_0022));//Sauron
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(21),Assets.CARD_0023));//Gothmog
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(22),Assets.CARD_0024));//Glaurung
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(23),Assets.CARD_0025));//Ungoliant
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(24),Assets.CARD_0026));//ORc
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(25),Assets.CARD_0027));//Spider
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(26),Assets.CARD_0028));//Warg
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(27),Assets.CARD_0029));//Wolf
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(28),Assets.CARD_0030));//Orc capt
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(29),Assets.CARD_0031));//Orc ranger
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(30),Assets.CARD_0032));//Orc warr
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(31),Assets.CARD_0033));//Morgoth slave
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(32),Assets.CARD_0034));//Dragon
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(33),Assets.CARD_0037));//Uruk
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(34),Assets.CARD_0038));//Elite uruk
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(35),Assets.CARD_0039));//Balrog
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(36),Assets.CARD_0040));//Orc elite
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(37),Assets.CARD_0041));//Ent
        CARDS_CACHE.add(new Card(game, Piece.PIECES_CACHE.get(38),Assets.CARD_0042));//Naugrim
    }
    
    public static int CARD_WIDTH = Hand.HAND_WIDTH / Hand.MAX_CARDS_IN_HAND;
    public static int CARD_HEIGHT = Hand.HAND_HEIGHT;
    
    
    private final Game game;
    protected final String name;
    private final Piece summonPiece;
    private final Element element;
    private final int cost;
    protected final BufferedImage image;
    
    
    private Card(final Game game, Piece piece, BufferedImage image) {
        super(CARD_WIDTH,CARD_HEIGHT);
        this.game = game;
        this.name = piece.getName();
        this.summonPiece = piece;
        this.cost = piece.calculateCost();
        this.element = piece.getElement();
        this.image = image;
    }
    
    private Card(Card card) {
        super(CARD_WIDTH,CARD_HEIGHT);
        game = card.game;
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
        game.selectedObject = this;
        game.getPanelManager().addObject(new TemporalPanel(
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
        if(game.selectedObject!= null && game.selectedObject.equals(this)) {
            g.setColor(Color.GREEN);
            g.drawRect((int)x, (int)y, width-1, height-1);
        }
        
    }
    
    
}
