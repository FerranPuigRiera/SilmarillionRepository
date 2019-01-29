/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import silmarillionreloaded.RenderableObject;
import silmarillionreloaded.entity.actions.Caster;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class Piece extends RenderableObject implements Target,Caster {
    
    public static Piece createNewPiece(int index, Alliance alliance)  {
        if(PIECES_CACHE.size() > index) {
            return new Piece(PIECES_CACHE.get(index),alliance);
        }
        throw new RuntimeException("Cannot create piece. "+index+" not found");
    }

    public static final List<Piece> PIECES_CACHE = new ArrayList<>();
    
    public static void init() {
        
        /*
        
        Stat rules
        
        health 500 - 2000   valar 2000, maiar 1800, maiarlow/semimaiar 1600, noldor/hight elf 1500, edain 1100, man 900
        damage 0 - 200                      sindar 900 orc elite 1200 orc warrior 800  orc base 500
        armor 0 - 50%
        elementalDamage 0 - 200
        elementalArmor 0 - 50%
        moves 1 - 6
        
        
        */
        
        
        Builder b1 = new Builder();
        b1.setName("Beren");
        b1.setElement(Element.NATURE);
        b1.setHealth(new Stat(1100));
        b1.setDamage(new Stat(90));
        b1.setArmor(new Stat(30));
        b1.setElementalDamage(new Stat(40));
        b1.setElementalArmor(new Stat(15));
        b1.setMoves(new Stat(4));
        b1.setImage(Assets.PIECE_0001);
        PIECES_CACHE.add(b1.build());
        
        Builder b2 = new Builder();
        b2.setName("Hurin");
        b2.setElement(Element.SHADOW);
        b2.setHealth(new Stat(1100));
        b2.setDamage(new Stat(120));
        b2.setArmor(new Stat(30));
        b2.setElementalDamage(new Stat(100));
        b2.setElementalArmor(new Stat(5));
        b2.setMoves(new Stat(3));
        b2.setImage(Assets.PIECE_0002);
        PIECES_CACHE.add(b2.build());
        
        Builder b3 = new Builder();
        b3.setName("Eagle");
        b3.setElement(Element.WIND);
        b3.setHealth(new Stat(650));
        b3.setDamage(new Stat(70));
        b3.setArmor(new Stat(15));
        b3.setElementalDamage(new Stat(80));
        b3.setElementalArmor(new Stat(15));
        b3.setMoves(new Stat(6));
        b3.setImage(Assets.PIECE_0003);
        PIECES_CACHE.add(b3.build());
        
        Builder b4 = new Builder();
        b4.setName("Sindar Elf");
        b4.setElement(Element.NATURE);
        b4.setHealth(new Stat(1100));
        b4.setDamage(new Stat(30));
        b4.setArmor(new Stat(30));
        b4.setElementalDamage(new Stat(60));
        b4.setElementalArmor(new Stat(50));
        b4.setMoves(new Stat(2));
        b4.setImage(Assets.PIECE_0004);
        PIECES_CACHE.add(b4.build());
        
        Builder b5 = new Builder();
        b5.setName("Numenorian Soldier");
        b5.setElement(Element.WATER);
        b5.setHealth(new Stat(750));
        b5.setDamage(new Stat(60));
        b5.setArmor(new Stat(20));
        b5.setElementalDamage(new Stat(40));
        b5.setElementalArmor(new Stat(10));
        b5.setMoves(new Stat(4));
        b5.setImage(Assets.PIECE_0005);
        PIECES_CACHE.add(b5.build());
        
        Builder b6 = new Builder();
        b6.setName("Huor");
        b6.setElement(Element.EARTH);
        b6.setHealth(new Stat(1100));
        b6.setDamage(new Stat(90));
        b6.setArmor(new Stat(15));
        b6.setElementalDamage(new Stat(80));
        b6.setElementalArmor(new Stat(20));
        b6.setMoves(new Stat(4));
        b6.setImage(Assets.PIECE_0006);
        PIECES_CACHE.add(b6.build());
        
        Builder b7 = new Builder();
        b7.setName("Tuor");
        b7.setElement(Element.EARTH);
        b7.setHealth(new Stat(1100));
        b7.setDamage(new Stat(80));
        b7.setArmor(new Stat(20));
        b7.setElementalDamage(new Stat(90));
        b7.setElementalArmor(new Stat(15));
        b7.setMoves(new Stat(4));
        b7.setImage(Assets.PIECE_0007);
        PIECES_CACHE.add(b7.build());
        
        Builder b8 = new Builder();
        b8.setName("Feanor");
        b8.setElement(Element.FIRE);
        b8.setHealth(new Stat(1550));
        b8.setDamage(new Stat(150));
        b8.setArmor(new Stat(20));
        b8.setElementalDamage(new Stat(130));
        b8.setElementalArmor(new Stat(40));
        b8.setMoves(new Stat(5));
        b8.setImage(Assets.PIECE_0008);
        PIECES_CACHE.add(b8.build());
        
        Builder b9 = new Builder();
        b9.setName("Fingolfin");
        b9.setElement(Element.WATER);
        b9.setHealth(new Stat(1500));
        b9.setDamage(new Stat(120));
        b9.setArmor(new Stat(50));
        b9.setElementalDamage(new Stat(140));
        b9.setElementalArmor(new Stat(45));
        b9.setMoves(new Stat(4));
        b9.setImage(Assets.PIECE_0009);
        PIECES_CACHE.add(b9.build());
        
        Builder b10 = new Builder();
        b10.setName("Luthien");
        b10.setElement(Element.NATURE);
        b10.setHealth(new Stat(1600));
        b10.setDamage(new Stat(80));
        b10.setArmor(new Stat(40));
        b10.setElementalDamage(new Stat(160));
        b10.setElementalArmor(new Stat(50));
        b10.setMoves(new Stat(5));
        b10.setImage(Assets.PIECE_0010);
        PIECES_CACHE.add(b10.build());
        
        Builder b11 = new Builder();
        b11.setName("Manwe");
        b11.setElement(Element.WIND);
        b11.setHealth(new Stat(2000));
        b11.setDamage(new Stat(170));
        b11.setArmor(new Stat(50));
        b11.setElementalDamage(new Stat(190));
        b11.setElementalArmor(new Stat(50));
        b11.setMoves(new Stat(6));
        b11.setImage(Assets.PIECE_0001);
        PIECES_CACHE.add(b11.build());
        
        Builder b12 = new Builder();
        b12.setName("Varda");
        b12.setElement(Element.NATURE);
        b12.setHealth(new Stat(2000));
        b12.setDamage(new Stat(180));
        b12.setArmor(new Stat(50));
        b12.setElementalDamage(new Stat(180));
        b12.setElementalArmor(new Stat(50));
        b12.setMoves(new Stat(6));
        b12.setImage(Assets.PIECE_0012);
        PIECES_CACHE.add(b12.build());
        
        Builder b13 = new Builder();
        b13.setName("Gondolin Soldier");
        b13.setElement(Element.WATER);
        b13.setHealth(new Stat(1500));
        b13.setDamage(new Stat(60));
        b13.setArmor(new Stat(35));
        b13.setElementalDamage(new Stat(60));
        b13.setElementalArmor(new Stat(40));
        b13.setMoves(new Stat(2));
        b13.setImage(Assets.PIECE_0013);
        PIECES_CACHE.add(b13.build());
        
        Builder b14 = new Builder();
        b14.setName("Doriah ranger");
        b14.setElement(Element.NATURE);
        b14.setHealth(new Stat(850));
        b14.setDamage(new Stat(100));
        b14.setArmor(new Stat(15));
        b14.setElementalDamage(new Stat(80));
        b14.setElementalArmor(new Stat(20));
        b14.setMoves(new Stat(6));
        b14.setImage(Assets.PIECE_0001);
        PIECES_CACHE.add(b14.build());
        
        Builder b15 = new Builder();
        b15.setName("Noldor elf");
        b15.setElement(Element.NATURE);
        b15.setHealth(new Stat(1500));
        b15.setDamage(new Stat(100));
        b15.setArmor(new Stat(20));
        b15.setElementalDamage(new Stat(100));
        b15.setElementalArmor(new Stat(20));
        b15.setMoves(new Stat(4));
        b15.setImage(Assets.PIECE_0015);
        PIECES_CACHE.add(b15.build());
        
        Builder b16 = new Builder();
        b16.setElement(Element.EARTH);
        b16.setHealth(new Stat(1450));
        b16.setDamage(new Stat(110));
        b16.setArmor(new Stat(45));
        b16.setElementalDamage(new Stat(55));
        b16.setElementalArmor(new Stat(20));
        b16.setMoves(new Stat(3));
        b16.setImage(Assets.PIECE_0016);
        PIECES_CACHE.add(b16.build());
        
        Builder b21 = new Builder();
        b21.setName("Windor");
        b21.setElement(Element.NATURE);
        b21.setHealth(new Stat(1400));
        b21.setDamage(new Stat(90));
        b21.setArmor(new Stat(30));
        b21.setElementalDamage(new Stat(110));
        b21.setElementalArmor(new Stat(30));
        b21.setMoves(new Stat(3));
        b21.setImage(Assets.PIECE_0021);
        PIECES_CACHE.add(b21.build());
        
        Builder b22 = new Builder();
        b22.setName("Cirdan");
        b22.setElement(Element.WATER);
        b22.setHealth(new Stat(1500));
        b22.setDamage(new Stat(100));
        b22.setArmor(new Stat(25));
        b22.setElementalDamage(new Stat(140));
        b22.setElementalArmor(new Stat(40));
        b22.setMoves(new Stat(4));
        b22.setImage(Assets.PIECE_0022);
        PIECES_CACHE.add(b22.build());
        
        Builder b23 = new Builder();
        b23.setName("Maedhros");
        b23.setElement(Element.FIRE);
        b23.setHealth(new Stat(1500));
        b23.setDamage(new Stat(120));
        b23.setArmor(new Stat(35));
        b23.setElementalDamage(new Stat(120));
        b23.setElementalArmor(new Stat(35));
        b23.setMoves(new Stat(4));
        b23.setImage(Assets.PIECE_0023);
        PIECES_CACHE.add(b23.build());
        
        Builder b24 = new Builder();
        b24.setName("Morgoth");
        b24.setElement(Element.SHADOW);
        b24.setHealth(new Stat(2200));
        b24.setDamage(new Stat(220));
        b24.setArmor(new Stat(50));
        b24.setElementalDamage(new Stat(220));
        b24.setElementalArmor(new Stat(50));
        b24.setMoves(new Stat(2));
        b24.setImage(Assets.PIECE_0024);
        PIECES_CACHE.add(b24.build());
        
        Builder b25 = new Builder();
        b25.setName("Sauron");
        b25.setElement(Element.SHADOW);
        b25.setHealth(new Stat(1900));
        b25.setDamage(new Stat(190));
        b25.setArmor(new Stat(50));
        b25.setElementalDamage(new Stat(190));
        b25.setElementalArmor(new Stat(50));
        b25.setMoves(new Stat(3));
        b25.setImage(Assets.PIECE_0025);
        PIECES_CACHE.add(b25.build());
        
        Builder b26 = new Builder();
        b26.setName("Gothmog");
        b26.setElement(Element.FIRE);
        b26.setHealth(new Stat(1750));
        b26.setDamage(new Stat(140));
        b26.setArmor(new Stat(40));
        b26.setElementalDamage(new Stat(200));
        b26.setElementalArmor(new Stat(50));
        b26.setMoves(new Stat(4));
        PIECES_CACHE.add(b26.build());
        
        Builder b27 = new Builder();
        b27.setName("Glaurung");
        b27.setElement(Element.FIRE);
        b27.setHealth(new Stat(1750));
        b27.setDamage(new Stat(160));
        b27.setArmor(new Stat(50));
        b27.setElementalDamage(new Stat(160));
        b27.setElementalArmor(new Stat(45));
        b27.setMoves(new Stat(5));
        b27.setImage(Assets.PIECE_0027);
        PIECES_CACHE.add(b27.build());
        
        Builder b28 = new Builder();
        b28.setName("Ungoliant");
        b28.setElement(Element.SHADOW);
        b28.setHealth(new Stat(1800));
        b28.setDamage(new Stat(100));
        b28.setArmor(new Stat(40));
        b28.setElementalDamage(new Stat(200));
        b28.setElementalArmor(new Stat(50));
        b28.setMoves(new Stat(5));
        b28.setImage(Assets.PIECE_0028);
        PIECES_CACHE.add(b28.build());
        
        
        Builder b30 = new Builder();
        b30.setName("Orc");
        b30.setElement(Element.EARTH);
        b30.setHealth(new Stat(500));
        b30.setDamage(new Stat(50));
        b30.setArmor(new Stat(10));
        b30.setElementalDamage(new Stat(10));
        b30.setElementalArmor(new Stat(10));
        b30.setMoves(new Stat(3));
        b30.setImage(Assets.PIECE_0030);
        PIECES_CACHE.add(b30.build());
        
        Builder b31 = new Builder();
        b31.setName("Spider");
        b31.setElement(Element.NATURE);
        b31.setHealth(new Stat(500));
        b31.setDamage(new Stat(30));
        b31.setArmor(new Stat(5));
        b31.setElementalDamage(new Stat(70));
        b31.setElementalArmor(new Stat(10));
        b31.setMoves(new Stat(4));
        b31.setImage(Assets.PIECE_0031);
        PIECES_CACHE.add(b31.build());
        
        Builder b32 = new Builder();
        b32.setName("Huarg");
        b32.setElement(Element.NATURE);
        b32.setHealth(new Stat(650));
        b32.setDamage(new Stat(65));
        b32.setArmor(new Stat(15));
        b32.setElementalDamage(new Stat(15));
        b32.setElementalArmor(new Stat(15));
        b32.setMoves(new Stat(5));
        b32.setImage(Assets.PIECE_0032);
        PIECES_CACHE.add(b32.build());
        
        Builder b33 = new Builder();
        b33.setName("Wolf");
        b33.setElement(Element.NATURE);
        b33.setHealth(new Stat(600));
        b33.setDamage(new Stat(50));
        b33.setArmor(new Stat(10));
        b33.setElementalDamage(new Stat(10));
        b33.setElementalArmor(new Stat(10));
        b33.setMoves(new Stat(5));
        b33.setImage(Assets.PIECE_0033);
        PIECES_CACHE.add(b33.build());
        
        Builder b34 = new Builder();
        b34.setName("Orc capitan");
        b34.setElement(Element.EARTH);
        b34.setHealth(new Stat(1000));
        b34.setDamage(new Stat(90));
        b34.setArmor(new Stat(40));
        b34.setElementalDamage(new Stat(45));
        b34.setElementalArmor(new Stat(25));
        b34.setMoves(new Stat(4));
        b34.setImage(Assets.PIECE_0034);
        PIECES_CACHE.add(b34.build());
        
        Builder b35 = new Builder();
        b35.setName("Orc ranger");
        b35.setElement(Element.EARTH);
        b35.setHealth(new Stat(800));
        b35.setDamage(new Stat(60));
        b35.setArmor(new Stat(25));
        b35.setElementalDamage(new Stat(40));
        b35.setElementalArmor(new Stat(25));
        b35.setMoves(new Stat(6));
        b35.setImage(Assets.PIECE_0035);
        PIECES_CACHE.add(b35.build());
        
        Builder b36 = new Builder();
        b36.setName("Orc warrior");
        b36.setElement(Element.EARTH);
        b36.setHealth(new Stat(800));
        b36.setDamage(new Stat(70));
        b36.setArmor(new Stat(25));
        b36.setElementalDamage(new Stat(40));
        b36.setElementalArmor(new Stat(20));
        b36.setMoves(new Stat(4));
        b36.setImage(Assets.PIECE_0036);
        PIECES_CACHE.add(b36.build());
        
        Builder b37 = new Builder();
        b37.setName("Morgoth slave");
        b37.setElement(Element.SHADOW);
        b37.setHealth(new Stat(500));
        b37.setDamage(new Stat(40));
        b37.setArmor(new Stat(5));
        b37.setElementalDamage(new Stat(40));
        b37.setElementalArmor(new Stat(5));
        b37.setMoves(new Stat(5));
        b37.setImage(Assets.PIECE_0037);
        PIECES_CACHE.add(b37.build());
        
        Builder b39 = new Builder();
        b39.setName("Dragon");
        b39.setElement(Element.FIRE);
        b39.setHealth(new Stat(1600));
        b39.setDamage(new Stat(100));
        b39.setArmor(new Stat(50));
        b39.setElementalDamage(new Stat(170));
        b39.setElementalArmor(new Stat(25));
        b39.setMoves(new Stat(6));
        b39.setImage(Assets.PIECE_0039);
        PIECES_CACHE.add(b39.build());
               
        Builder b42 = new Builder();
        b42.setName("Uruk-hai");
        b42.setElement(Element.EARTH);
        b42.setHealth(new Stat(600));
        b42.setDamage(new Stat(60));
        b42.setArmor(new Stat(20));
        b42.setElementalDamage(new Stat(25));
        b42.setElementalArmor(new Stat(10));
        b42.setMoves(new Stat(4));
        b42.setImage(Assets.PIECE_0042);
        PIECES_CACHE.add(b42.build());
        
        Builder b43 = new Builder();
        b43.setName("Elite uruk-hai");
        b43.setElement(Element.EARTH);
        b43.setHealth(new Stat(800));
        b43.setDamage(new Stat(70));
        b43.setArmor(new Stat(30));
        b43.setElementalDamage(new Stat(30));
        b43.setElementalArmor(new Stat(15));
        b43.setMoves(new Stat(4));
        b43.setImage(Assets.PIECE_0043);
        PIECES_CACHE.add(b43.build());
        
        Builder b44 = new Builder();
        b44.setName("Balrog");
        b44.setElement(Element.FIRE);
        b44.setHealth(new Stat(1700));
        b44.setDamage(new Stat(100));
        b44.setArmor(new Stat(30));
        b44.setElementalDamage(new Stat(180));
        b44.setElementalArmor(new Stat(45));
        b44.setMoves(new Stat(3));
        b44.setImage(Assets.PIECE_0044);
        PIECES_CACHE.add(b44.build());
        
        Builder b45 = new Builder();
        b45.setName("Orc elite");
        b45.setElement(Element.NATURE);
        b45.setHealth(new Stat(1200));
        b45.setDamage(new Stat(130));
        b45.setArmor(new Stat(40));
        b45.setElementalDamage(new Stat(50));
        b45.setElementalArmor(new Stat(20));
        b45.setMoves(new Stat(4));
        b45.setImage(Assets.PIECE_0045);
        PIECES_CACHE.add(b45.build());
        
        Builder b46 = new Builder();
        b46.setName("Ent");
        b46.setElement(Element.NATURE);
        b46.setHealth(new Stat(1800));
        b46.setDamage(new Stat(140));
        b46.setArmor(new Stat(50));
        b46.setElementalDamage(new Stat(120));
        b46.setElementalArmor(new Stat(50));
        b46.setMoves(new Stat(1));
        b46.setImage(Assets.PIECE_0046);
        PIECES_CACHE.add(b46.build());
        
        Builder b47 = new Builder();
        b47.setName("Naugrim");
        b47.setElement(Element.EARTH);
        b47.setHealth(new Stat(1400));
        b47.setDamage(new Stat(100));
        b47.setArmor(new Stat(45));
        b47.setElementalDamage(new Stat(50));
        b47.setElementalArmor(new Stat(20));
        b47.setMoves(new Stat(2));
        b47.setImage(Assets.PIECE_0047);
        PIECES_CACHE.add(b47.build());
    }
    private final String name;
    private final Stat health; 
    private final Stat damage;
    private final Stat armor;
    private final Element element;
    private final Stat elementalDamage;
    private final Stat elementalArmor;
    private final Stat moves;
    
    private final BufferedImage image;
    
    private final Alliance alliance;
    
    private Piece(Piece piece, Alliance alliance) {
        name = piece.name;
        health = piece.health;
        damage = piece.damage;
        armor = piece.armor;
        element = piece.element;
        elementalDamage = piece.elementalDamage;
        elementalArmor = piece.elementalArmor;
        moves = piece.moves;
        image = piece.image;
        this.alliance = alliance;
    }
    
    private Piece(Builder builder) {
        name = builder.name;
        health = builder.health;
        damage = builder.damage;
        armor = builder.armor;
        element = builder.element;
        elementalDamage = builder.elementalDamage;
        elementalArmor = builder.elementalArmor;
        moves = builder.moves;
        image = builder.image;
        alliance = Alliance.NULL;
    }
    public boolean isAlive() {
        return health.getValue() <= 0;
    }   
    public Alliance getAlliance() {
        return alliance;
    }
    
    @Override
    public void tick() {
       // super.setPosition(x, y);
         
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }
    
    public String getName() {
        return name;
    }
    
    public Element getElement() {
        return element;
    }
    
    public int calculateCost() {
        return health.getValue()/10 + damage.getValue() + armor.getValue() + 
               elementalDamage.getValue() + elementalArmor.getValue() + moves.getValue()*3;
    }
    
   
    
    @Override
    public void onClick() {
        Game.showInfoPanel(this);
    }
    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public boolean isPiece() {
        return true;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public Piece getPiece() {
        return this;
    }

    @Override
    public boolean isTile() {
        return false;
    }

    @Override
    public Tile getTile() {
        return null;
    }
   
    public static class King extends Piece {
        
        public King(Builder builder) {
            super(builder);
        }
        
    }
    
    
    private static class Builder {
        private String name;
        private Stat health;
        private Stat damage;
        private Stat armor;
        private Element element;
        private Stat elementalDamage;
        private Stat elementalArmor;
        private Stat moves;
        private BufferedImage image;
        
        public Builder() {
            name = "New Piece";
            health = new Stat(100);
            damage = new Stat(10);
            armor = new Stat(5);
            element = Element.NULL;
            elementalDamage = new Stat(10);
            elementalArmor = new Stat(5);
            moves = new Stat(3);
            image = Assets.PIECE_0000;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHealth(Stat health) {
            this.health = health;
        }

        public void setDamage(Stat damage) {
            this.damage = damage;
        }

        public void setArmor(Stat armor) {
            this.armor = armor;
        }

        public void setElement(Element element) {
            this.element = element;
        }

        public void setElementalDamage(Stat elementalDamage) {
            this.elementalDamage = elementalDamage;
        }

        public void setElementalArmor(Stat elementalArmor) {
            this.elementalArmor = elementalArmor;
        }

        public void setMoves(Stat moves) {
            this.moves = moves;
        }
        public void setImage(BufferedImage bi) {
            this.image = bi;
        }
        
        public Piece build() {
            return new Piece(this);
        }
        
    }
    
    
}
