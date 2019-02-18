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
        CARDS_CACHE.add(new Card(game, Piece.BEREN,Assets.CARD_0001));//Beren
        CARDS_CACHE.add(new Card(game, Piece.HURIN,Assets.CARD_0002));//Hurin
        CARDS_CACHE.add(new Card(game, Piece.EAGLE,Assets.CARD_0003));//Eagle
        CARDS_CACHE.add(new Card(game, Piece.SINDAR_ELF,Assets.CARD_0004));//Sindar elf
        CARDS_CACHE.add(new Card(game, Piece.NUMENORIAN_SOLDIER ,Assets.CARD_0005));//Numenorian
        CARDS_CACHE.add(new Card(game, Piece.HUOR,Assets.CARD_0006));//Huor
        CARDS_CACHE.add(new Card(game, Piece.TUOR,Assets.CARD_0007));//Tuor
        CARDS_CACHE.add(new Card(game, Piece.FEANOR,Assets.CARD_0008));//Feanor
        CARDS_CACHE.add(new Card(game, Piece.FINGOLFIN,Assets.CARD_0009));//Fingolfin
        CARDS_CACHE.add(new Card(game, Piece.LUTHIEN,Assets.CARD_0010));//Luthien
        CARDS_CACHE.add(new Card(game, Piece.MANWE,Assets.CARD_0011));//Manwe
        CARDS_CACHE.add(new Card(game, Piece.VARDA,Assets.CARD_0012));//Varda
        CARDS_CACHE.add(new Card(game, Piece.GONDOLIN_SOLDIER,Assets.CARD_0013));//Gondolin soldier
        CARDS_CACHE.add(new Card(game, Piece.DORIAH_RANGER,Assets.CARD_0014));//Doriah ranger
        CARDS_CACHE.add(new Card(game, Piece.NOLDOR_ELF,Assets.CARD_0015));//Noldor elf
        CARDS_CACHE.add(new Card(game, Piece.DWARF_BELEGOST,Assets.CARD_0016));//Dwarf belegost
        CARDS_CACHE.add(new Card(game, Piece.WINDOR,Assets.CARD_0018));//Windor
        CARDS_CACHE.add(new Card(game, Piece.CIRDAN,Assets.CARD_0019));//Cirdan
        CARDS_CACHE.add(new Card(game, Piece.MAEDHROS,Assets.CARD_0020));//Maedros
        CARDS_CACHE.add(new Card(game, Piece.MORGOTH,Assets.CARD_0021));//Morgoth
        CARDS_CACHE.add(new Card(game, Piece.SAURON,Assets.CARD_0022));//Sauron
        CARDS_CACHE.add(new Card(game, Piece.GOTHMOG,Assets.CARD_0023));//Gothmog
        CARDS_CACHE.add(new Card(game, Piece.GLAURUNG,Assets.CARD_0024));//Glaurung
        CARDS_CACHE.add(new Card(game, Piece.UNGOLIANT,Assets.CARD_0025));//Ungoliant
        CARDS_CACHE.add(new Card(game, Piece.ORC,Assets.CARD_0026));//ORc
        CARDS_CACHE.add(new Card(game, Piece.SPIDER,Assets.CARD_0027));//Spider
        CARDS_CACHE.add(new Card(game, Piece.WARG,Assets.CARD_0028));//Warg
        CARDS_CACHE.add(new Card(game, Piece.WOLF,Assets.CARD_0029));//Wolf
        CARDS_CACHE.add(new Card(game, Piece.ORC_CAPITAN,Assets.CARD_0030));//Orc capt
        CARDS_CACHE.add(new Card(game, Piece.ORC_RANGER,Assets.CARD_0031));//Orc ranger
        CARDS_CACHE.add(new Card(game, Piece.ORC_WARRIOR,Assets.CARD_0032));//Orc warr
        CARDS_CACHE.add(new Card(game, Piece.MORGOTH_SLAVE,Assets.CARD_0033));//Morgoth slave
        CARDS_CACHE.add(new Card(game, Piece.DRAGON,Assets.CARD_0034));//Dragon
        CARDS_CACHE.add(new Card(game, Piece.URUK_HAI,Assets.CARD_0037));//Uruk
        CARDS_CACHE.add(new Card(game, Piece.ELITE_URUK_HAI,Assets.CARD_0038));//Elite uruk
        CARDS_CACHE.add(new Card(game, Piece.BALROG,Assets.CARD_0039));//Balrog
        CARDS_CACHE.add(new Card(game, Piece.ELITE_URUK_HAI,Assets.CARD_0040));//Orc elite
        CARDS_CACHE.add(new Card(game, Piece.ENT,Assets.CARD_0041));//Ent
        CARDS_CACHE.add(new Card(game, Piece.NAUGRIM,Assets.CARD_0042));//Naugrim
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
