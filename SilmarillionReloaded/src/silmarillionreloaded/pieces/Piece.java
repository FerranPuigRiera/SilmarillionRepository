/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import silmarillionreloaded.renderableObjects.Panel.PiecePanel;
import silmarillionreloaded.renderableObjects.RenderableObject;
import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.actions.PlayableAction;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.game.ObjectSelected;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.pieces.Stat.Armor;
import silmarillionreloaded.pieces.Stat.ArmorPenetration;
import silmarillionreloaded.pieces.Stat.BlockChance;
import silmarillionreloaded.pieces.Stat.CriticalChance;
import silmarillionreloaded.pieces.Stat.Damage;
import silmarillionreloaded.pieces.Stat.ElementalArmor;
import silmarillionreloaded.pieces.Stat.ElementalDamage;
import silmarillionreloaded.pieces.Stat.Health;
import silmarillionreloaded.pieces.Stat.LifeSteal;
import silmarillionreloaded.pieces.Stat.Moves;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class Piece extends RenderableObject implements ObjectSelected {

    public static Piece BEREN, HURIN, EAGLE, SINDAR_ELF, NUMENORIAN_SOLDIER, HUOR,
                        TUOR, FEANOR, FINGOLFIN, LUTHIEN, MANWE, VARDA, GONDOLIN_SOLDIER,
                        DORIAH_RANGER, NOLDOR_ELF, DWARF_BELEGOST, WINDOR, CIRDAN, MAEDHROS,
                        MORGOTH, SAURON, GOTHMOG, GLAURUNG, UNGOLIANT, ORC, SPIDER, 
                        WARG, WOLF, ORC_CAPITAN, ORC_RANGER, ORC_WARRIOR, MORGOTH_SLAVE,
                        DRAGON, URUK_HAI, ELITE_URUK_HAI,BALROG, ORC_ELITE, ENT, NAUGRIM; 

                        
               
    
    public static Piece createNewPiece(int index, Alliance alliance)  {
        if(PIECES_CACHE.size() > index) {
            Piece piece = new Piece(PIECES_CACHE.get(index));
            piece.setAlliance(alliance);
            return piece;
        } else {
            throw new RuntimeException("Cannot create piece. "+index+" not found");
        }
    }

    public static King createNewKing(int index, Alliance alliance) {

        if(PIECES_CACHE.size() > index) {
            King piece = new King(PIECES_CACHE.get(index));
            piece.setAlliance(alliance);
            return piece;
        } else {
            throw new RuntimeException("Cannot create piece. "+index+" not found");
        }
        
    }
    
    public static int getRandomIndexOnCache() {
        Random r = new Random();
        return r.nextInt(PIECES_CACHE.size());
    }
    
    
    public static final List<Piece> PIECES_CACHE = new ArrayList<>();
    
    public static void init(final Game game) {
        
        /*
        
        Stat rules
        
        health 500 - 2000   valar 2000, maiar 1800, maiarlow/semimaiar 1600, noldor/hight elf 1500, edain 1100, man 900
        damage 0 - 200                      sindar 900 orc elite 1200 orc warrior 800  orc base 500
        armor 0 - 50%
        elementalDamage 0 - 200
        elementalArmor 0 - 50%
        moves 1 - 6
        
        
        */
        
        
        Builder b1 = new Builder(game);
        b1.setName("Beren");
        b1.setElement(Element.NATURE);
        b1.setHealth(1100);
        b1.setDamage(90);
        b1.setArmor(30);
        b1.setElementalDamage(40);
        b1.setElementalArmor(15);
        b1.setMoves(4);
        b1.setImage(Assets.PIECE_0001);
        
        Builder b2 = new Builder(game);
        b2.setName("Hurin");
        b2.setElement(Element.SHADOW);
        b2.setHealth(1100);
        b2.setDamage(120);
        b2.setArmor(30);
        b2.setElementalDamage(100);
        b2.setElementalArmor(5);
        b2.setMoves(3);
        b2.setImage(Assets.PIECE_0002);
        
        Builder b3 = new Builder(game);
        b3.setName("Eagle");
        b3.setElement(Element.WIND);
        b3.setHealth(650);
        b3.setDamage(70);
        b3.setArmor(15);
        b3.setElementalDamage(80);
        b3.setElementalArmor(15);
        b3.setMoves(6);
        b3.setImage(Assets.PIECE_0003);
        
        Builder b4 = new Builder(game);
        b4.setName("Sindar Elf");
        b4.setElement(Element.NATURE);
        b4.setHealth(1100);
        b4.setDamage(30);
        b4.setArmor(30);
        b4.setElementalDamage(60);
        b4.setElementalArmor(50);
        b4.setMoves(2);
        b4.setImage(Assets.PIECE_0004);
        
        Builder b5 = new Builder(game);
        b5.setName("Numenorian Soldier");
        b5.setElement(Element.WATER);
        b5.setHealth(750);
        b5.setDamage(60);
        b5.setArmor(20);
        b5.setElementalDamage(40);
        b5.setElementalArmor(10);
        b5.setMoves(4);
        b5.setImage(Assets.PIECE_0005);
        
        Builder b6 = new Builder(game);
        b6.setName("Huor");
        b6.setElement(Element.EARTH);
        b6.setHealth(1100);
        b6.setDamage(90);
        b6.setArmor(15);
        b6.setElementalDamage(80);
        b6.setElementalArmor(20);
        b6.setMoves(4);
        b6.setImage(Assets.PIECE_0006);
        
        Builder b7 = new Builder(game);
        b7.setName("Tuor");
        b7.setElement(Element.EARTH);
        b7.setHealth(1100);
        b7.setDamage(80);
        b7.setArmor(20);
        b7.setElementalDamage(90);
        b7.setElementalArmor(15);
        b7.setMoves(4);
        b7.setImage(Assets.PIECE_0007);

        Builder b8 = new Builder(game);
        b8.setName("Feanor");
        b8.setElement(Element.FIRE);
        b8.setHealth(1550);
        b8.setDamage(150);
        b8.setArmor(20);
        b8.setElementalDamage(130);
        b8.setElementalArmor(40);
        b8.setMoves(5);
        b8.setImage(Assets.PIECE_0008);
        
        Builder b9 = new Builder(game);
        b9.setName("Fingolfin");
        b9.setElement(Element.WATER);
        b9.setHealth(1500);
        b9.setDamage(120);
        b9.setArmor(50);
        b9.setElementalDamage(140);
        b9.setElementalArmor(45);
        b9.setMoves(4);
        b9.setImage(Assets.PIECE_0009);
        
        Builder b10 = new Builder(game);
        b10.setName("Luthien");
        b10.setElement(Element.NATURE);
        b10.setHealth(1600);
        b10.setDamage(80);
        b10.setArmor(40);
        b10.setElementalDamage(160);
        b10.setElementalArmor(50);
        b10.setMoves(5);
        b10.setImage(Assets.PIECE_0010);

        Builder b11 = new Builder(game);
        b11.setName("Manwe");
        b11.setElement(Element.WIND);
        b11.setHealth(2000);
        b11.setDamage(170);
        b11.setArmor(50);
        b11.setElementalDamage(190);
        b11.setElementalArmor(50);
        b11.setMoves(6);
        b11.setImage(Assets.PIECE_0011);
        
        Builder b12 = new Builder(game);
        b12.setName("Varda");
        b12.setElement(Element.NATURE);
        b12.setHealth(2000);
        b12.setDamage(180);
        b12.setArmor(50);
        b12.setElementalDamage(180);
        b12.setElementalArmor(50);
        b12.setMoves(6);
        b12.setImage(Assets.PIECE_0012);
        
        Builder b13 = new Builder(game);
        b13.setName("Gondolin Soldier");
        b13.setElement(Element.WATER);
        b13.setHealth(1500);
        b13.setDamage(60);
        b13.setArmor(35);
        b13.setElementalDamage(60);
        b13.setElementalArmor(40);
        b13.setMoves(2);
        b13.setImage(Assets.PIECE_0013);
        
        Builder b14 = new Builder(game);
        b14.setName("Doriah ranger");
        b14.setElement(Element.NATURE);
        b14.setHealth(850);
        b14.setDamage(100);
        b14.setArmor(15);
        b14.setElementalDamage(80);
        b14.setElementalArmor(20);
        b14.setMoves(6);
        b14.setImage(Assets.PIECE_0014);
        
        Builder b15 = new Builder(game);
        b15.setName("Noldor elf");
        b15.setElement(Element.NATURE);
        b15.setHealth(1500);
        b15.setDamage(100);
        b15.setArmor(20);
        b15.setElementalDamage(100);
        b15.setElementalArmor(20);
        b15.setMoves(4);
        b15.setImage(Assets.PIECE_0015);
        
        Builder b16 = new Builder(game);
        b16.setName("Dwarf of Belegost");
        b16.setElement(Element.EARTH);
        b16.setHealth(1450);
        b16.setDamage(110);
        b16.setArmor(45);
        b16.setElementalDamage(55);
        b16.setElementalArmor(20);
        b16.setMoves(3);
        b16.setImage(Assets.PIECE_0016);
        
        Builder b21 = new Builder(game);
        b21.setName("Windor");
        b21.setElement(Element.NATURE);
        b21.setHealth(1400);
        b21.setDamage(90);
        b21.setArmor(30);
        b21.setElementalDamage(110);
        b21.setElementalArmor(30);
        b21.setMoves(3);
        b21.setImage(Assets.PIECE_0021);
        
        Builder b22 = new Builder(game);
        b22.setName("Cirdan");
        b22.setElement(Element.WATER);
        b22.setHealth(1500);
        b22.setDamage(100);
        b22.setArmor(25);
        b22.setElementalDamage(140);
        b22.setElementalArmor(40);
        b22.setMoves(4);
        b22.setImage(Assets.PIECE_0022);
        
        Builder b23 = new Builder(game);
        b23.setName("Maedhros");
        b23.setElement(Element.FIRE);
        b23.setHealth(1500);
        b23.setDamage(120);
        b23.setArmor(35);
        b23.setElementalDamage(120);
        b23.setElementalArmor(35);
        b23.setMoves(4);
        b23.setImage(Assets.PIECE_0023);
        
        Builder b24 = new Builder(game);
        b24.setName("Morgoth");
        b24.setElement(Element.SHADOW);
        b24.setHealth(2200);
        b24.setDamage(220);
        b24.setArmor(50);
        b24.setElementalDamage(220);
        b24.setElementalArmor(50);
        b24.setMoves(2);
        b24.setImage(Assets.PIECE_0024);
        
        Builder b25 = new Builder(game);
        b25.setName("Sauron");
        b25.setElement(Element.SHADOW);
        b25.setHealth(1900);
        b25.setDamage(190);
        b25.setArmor(50);
        b25.setElementalDamage(190);
        b25.setElementalArmor(50);
        b25.setMoves(3);
        b25.setImage(Assets.PIECE_0025);
        
        Builder b26 = new Builder(game);
        b26.setName("Gothmog");
        b26.setElement(Element.FIRE);
        b26.setHealth(1750);
        b26.setDamage(140);
        b26.setArmor(40);
        b26.setElementalDamage(200);
        b26.setElementalArmor(50);
        b26.setMoves(4);
        b26.setImage(Assets.PIECE_0026);
        
        Builder b27 = new Builder(game);
        b27.setName("Glaurung");
        b27.setElement(Element.FIRE);
        b27.setHealth(1750);
        b27.setDamage(160);
        b27.setArmor(50);
        b27.setElementalDamage(160);
        b27.setElementalArmor(45);
        b27.setMoves(5);
        b27.setImage(Assets.PIECE_0027);
        
        Builder b28 = new Builder(game);
        b28.setName("Ungoliant");
        b28.setElement(Element.SHADOW);
        b28.setHealth(1800);
        b28.setDamage(100);
        b28.setArmor(40);
        b28.setElementalDamage(200);
        b28.setElementalArmor(50);
        b28.setMoves(5);
        b28.setImage(Assets.PIECE_0028);
        
        
        Builder b30 = new Builder(game);
        b30.setName("Orc");
        b30.setElement(Element.EARTH);
        b30.setHealth(500);
        b30.setDamage(50);
        b30.setArmor(10);
        b30.setElementalDamage(10);
        b30.setElementalArmor(10);
        b30.setMoves(3);
        b30.setImage(Assets.PIECE_0030);
        
        Builder b31 = new Builder(game);
        b31.setName("Spider");
        b31.setElement(Element.NATURE);
        b31.setHealth(500);
        b31.setDamage(30);
        b31.setArmor(5);
        b31.setElementalDamage(70);
        b31.setElementalArmor(10);
        b31.setMoves(4);
        b31.setImage(Assets.PIECE_0031);
        
        Builder b32 = new Builder(game);
        b32.setName("Warg");
        b32.setElement(Element.NATURE);
        b32.setHealth(650);
        b32.setDamage(65);
        b32.setArmor(15);
        b32.setElementalDamage(15);
        b32.setElementalArmor(15);
        b32.setMoves(5);
        b32.setImage(Assets.PIECE_0032);
        
        Builder b33 = new Builder(game);
        b33.setName("Wolf");
        b33.setElement(Element.NATURE);
        b33.setHealth(600);
        b33.setDamage(50);
        b33.setArmor(10);
        b33.setElementalDamage(10);
        b33.setElementalArmor(10);
        b33.setMoves(5);
        b33.setImage(Assets.PIECE_0033);
        
        Builder b34 = new Builder(game);
        b34.setName("Orc capitan");
        b34.setElement(Element.EARTH);
        b34.setHealth(1000);
        b34.setDamage(90);
        b34.setArmor(40);
        b34.setElementalDamage(45);
        b34.setElementalArmor(25);
        b34.setMoves(4);
        b34.setImage(Assets.PIECE_0034);
        
        Builder b35 = new Builder(game);
        b35.setName("Orc ranger");
        b35.setElement(Element.EARTH);
        b35.setHealth(800);
        b35.setDamage(60);
        b35.setArmor(25);
        b35.setElementalDamage(40);
        b35.setElementalArmor(25);
        b35.setMoves(6);
        b35.setImage(Assets.PIECE_0035);
        
        Builder b36 = new Builder(game);
        b36.setName("Orc warrior");
        b36.setElement(Element.EARTH);
        b36.setHealth(800);
        b36.setDamage(70);
        b36.setArmor(25);
        b36.setElementalDamage(40);
        b36.setElementalArmor(20);
        b36.setMoves(4);
        b36.setImage(Assets.PIECE_0036);
        
        Builder b37 = new Builder(game);
        b37.setName("Morgoth slave");
        b37.setElement(Element.SHADOW);
        b37.setHealth(500);
        b37.setDamage(40);
        b37.setArmor(5);
        b37.setElementalDamage(40);
        b37.setElementalArmor(5);
        b37.setMoves(5);
        b37.setImage(Assets.PIECE_0037);
        
        Builder b39 = new Builder(game);
        b39.setName("Dragon");
        b39.setElement(Element.FIRE);
        b39.setHealth(1600);
        b39.setDamage(100);
        b39.setArmor(50);
        b39.setElementalDamage(170);
        b39.setElementalArmor(25);
        b39.setMoves(6);
        b39.setImage(Assets.PIECE_0039);
               
        Builder b42 = new Builder(game);
        b42.setName("Uruk-hai");
        b42.setElement(Element.EARTH);
        b42.setHealth(600);
        b42.setDamage(60);
        b42.setArmor(20);
        b42.setElementalDamage(25);
        b42.setElementalArmor(10);
        b42.setMoves(4);
        b42.setImage(Assets.PIECE_0042);
        
        Builder b43 = new Builder(game);
        b43.setName("Elite uruk-hai");
        b43.setElement(Element.EARTH);
        b43.setHealth(800);
        b43.setDamage(70);
        b43.setArmor(30);
        b43.setElementalDamage(30);
        b43.setElementalArmor(15);
        b43.setMoves(4);
        b43.setImage(Assets.PIECE_0043);
        
        Builder b44 = new Builder(game);
        b44.setName("Balrog");
        b44.setElement(Element.FIRE);
        b44.setHealth(1700);
        b44.setDamage(100);
        b44.setArmor(30);
        b44.setElementalDamage(180);
        b44.setElementalArmor(45);
        b44.setMoves(3);
        b44.setImage(Assets.PIECE_0044);
        
        Builder b45 = new Builder(game);
        b45.setName("Orc elite");
        b45.setElement(Element.NATURE);
        b45.setHealth(1200);
        b45.setDamage(130);
        b45.setArmor(40);
        b45.setElementalDamage(50);
        b45.setElementalArmor(20);
        b45.setMoves(4);
        b45.setImage(Assets.PIECE_0045);
        
        Builder b46 = new Builder(game);
        b46.setName("Ent");
        b46.setElement(Element.NATURE);
        b46.setHealth(1800);
        b46.setDamage(140);
        b46.setArmor(50);
        b46.setElementalDamage(120);
        b46.setElementalArmor(50);
        b46.setMoves(1);
        b46.setImage(Assets.PIECE_0046);
        
        Builder b47 = new Builder(game);
        b47.setName("Naugrim");
        b47.setElement(Element.EARTH);
        b47.setHealth(1400);
        b47.setDamage(100);
        b47.setArmor(45);
        b47.setElementalDamage(50);
        b47.setElementalArmor(20);
        b47.setMoves(2);
        b47.setImage(Assets.PIECE_0047);
        
        BEREN = b1.build(); PIECES_CACHE.add(BEREN);
        HURIN = b2.build(); PIECES_CACHE.add(HURIN);
        EAGLE = b3.build(); PIECES_CACHE.add(EAGLE);
        SINDAR_ELF = b4.build(); PIECES_CACHE.add(SINDAR_ELF);
        NUMENORIAN_SOLDIER = b5.build(); PIECES_CACHE.add(NUMENORIAN_SOLDIER);
        HUOR = b6.build(); PIECES_CACHE.add(HUOR);
        TUOR = b7.build(); PIECES_CACHE.add(TUOR);
        FEANOR = b8.build(); PIECES_CACHE.add(FEANOR);
        FINGOLFIN = b9.build(); PIECES_CACHE.add(FINGOLFIN);
        LUTHIEN = b10.build(); PIECES_CACHE.add(LUTHIEN);
        MANWE = b11.build(); PIECES_CACHE.add(MANWE);
        VARDA = b12.build(); PIECES_CACHE.add(VARDA);
        GONDOLIN_SOLDIER = b13.build(); PIECES_CACHE.add(GONDOLIN_SOLDIER);
        DORIAH_RANGER = b14.build(); PIECES_CACHE.add(DORIAH_RANGER);
        NOLDOR_ELF = b15.build(); PIECES_CACHE.add(NOLDOR_ELF);
        DWARF_BELEGOST = b16.build(); PIECES_CACHE.add(DWARF_BELEGOST);
        WINDOR = b21.build(); PIECES_CACHE.add(WINDOR);
        CIRDAN = b22.build(); PIECES_CACHE.add(CIRDAN);
        MAEDHROS = b23.build(); PIECES_CACHE.add(MAEDHROS);
        MORGOTH = b24.build(); PIECES_CACHE.add(MORGOTH);
        SAURON = b25.build(); PIECES_CACHE.add(SAURON);
        GOTHMOG = b26.build(); PIECES_CACHE.add(GOTHMOG);
        GLAURUNG = b27.build(); PIECES_CACHE.add(GLAURUNG);
        UNGOLIANT = b28.build(); PIECES_CACHE.add(UNGOLIANT);
        ORC = b30.build(); PIECES_CACHE.add(ORC);
        SPIDER = b31.build(); PIECES_CACHE.add(SPIDER); 
        WARG = b32.build(); PIECES_CACHE.add(WARG);
        WOLF = b33.build(); PIECES_CACHE.add(WOLF);
        ORC_CAPITAN = b34.build(); PIECES_CACHE.add(ORC_CAPITAN);
        ORC_RANGER = b35.build(); PIECES_CACHE.add(ORC_RANGER);
        ORC_WARRIOR = b36.build(); PIECES_CACHE.add(ORC_WARRIOR);
        MORGOTH_SLAVE = b37.build(); PIECES_CACHE.add(MORGOTH_SLAVE);
        DRAGON = b39.build(); PIECES_CACHE.add(DRAGON);
        URUK_HAI = b42.build(); PIECES_CACHE.add(URUK_HAI); 
        ELITE_URUK_HAI = b43.build(); PIECES_CACHE.add(ELITE_URUK_HAI);
        BALROG = b44.build(); PIECES_CACHE.add(BALROG);
        ORC_ELITE = b45.build(); PIECES_CACHE.add(ORC_ELITE);
        ENT = b46.build(); PIECES_CACHE.add(ENT);
        NAUGRIM = b47.build(); PIECES_CACHE.add(NAUGRIM);
        
    }
    
    private final Game game;
    private final String name;
    protected final PieceStats stats;
    private final Element element;
    
    private final BufferedImage image;
    private Alliance alliance;
    private float availableMoves;
    
    //private final SpriteAnimation aura; 
    private final PieceBar hpBar;
    
    
    public Piece(Piece piece) {
        super(Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        game = piece.game;
        name = piece.name;
        element = piece.element;
        stats = new PieceStats(piece.stats);
        image = piece.image;
        alliance = piece.alliance;
        availableMoves = (int)stats.getRealMoves();
        hpBar = new PieceBar(game,this);  
    }
    
    private Piece(Builder builder) {
        super(Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        game = builder.game;
        name = builder.name;
        element = builder.element;
        stats = new PieceStats(builder.pieceStats);
        image = builder.image;
        alliance = Alliance.NULL;
        availableMoves = (int)stats.getRealMoves();
        hpBar = new PieceBar(game,this);
    }

    public float getAvailableMoves() {
        return availableMoves;
    }

    public void setAvailableMoves(float availableMoves) {
        this.availableMoves = availableMoves;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.game);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.stats);
        hash = 29 * hash + Objects.hashCode(this.element);
        hash = 29 * hash + Objects.hashCode(this.image);
        hash = 29 * hash + Objects.hashCode(this.alliance);
        hash = 29 * hash + Objects.hashCode(availableMoves);
        hash = 29 * hash + Objects.hashCode(this.hpBar);
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
        final Piece other = (Piece) obj;
        if (this.availableMoves != other.availableMoves) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.stats, other.stats)) {
            return false;
        }
        if (this.element != other.element) {
            return false;
        }
        if (this.alliance != other.alliance) {
            return false;
        }
        return true;
    }
    
    
    
    public boolean isAlive() {
        return stats.getRealHealh() <= 0;
    }   
    public Alliance getAlliance() {
        return alliance;
    }
    
    @Override
    public void tick() {
        hpBar.tick();
         
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
    
    public float getMaxHealth() {
        return stats.getHealth().getMaxValue();
    }
    
    public float getHealth() {
        return stats.getRealHealh();
    }

    public float getDamage() {
        return stats.getRealDamage();
    }

    public float getArmor() {
        return stats.getRealArmor();
    }

    public float getElementalDamage() {
        return stats.getRealElementalDamage();
    }

    public float getElementalArmor() {
        return stats.getRealElementalArmor();
    }

    public float getMoves() {
        return stats.getRealMoves();
    }

    public float getCriticalChance() {
        return stats.getRealCritChance();
    }

    public float getBlockChance() {
        return stats.getRealBlockChance();
    }

    public float getLifeSteal() {
        return stats.getRealLifeSteal();
    }

    public float getArmorPenetration() {
        return stats.getRealArmorPenetration();
    }
    
    
    @Override
    public void render(Graphics g, float x, float y) {
        
        int print_x = (int)(x + game.getGameCamera().getxOffset());
        int print_y = (int)(y + game.getGameCamera().getyOffset());
        
        g.setColor(alliance.getRenderColor());
        g.fillOval((int)print_x - 1, (int)print_y - 1, width + 2, height + 2);
        g.drawImage(image, (int)print_x , (int)print_y, width, height, null);
        hpBar.render(g, (int)print_x, (int)print_y);
    }
    
    public String getName() {
        return name;
    }
    
    public Element getElement() {
        return element;
    }
    
    public int calculateCost() {
        return (int) (stats.getRealHealh()/10 + stats.getRealDamage() + stats.getRealArmor() + 
               stats.getRealElementalDamage() + stats.getRealElementalArmor() + stats.getRealMoves()*3);
    }
    
   
    
    @Override
    public void onClick(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {

            game.selectedObject = this;
            int x = game.getWorld().findTilesPieceOnWorld(this).getCoordinate_x()*Tile.TILE_WIDTH;
            int y = game.getWorld().findTilesPieceOnWorld(this).getCoordinate_y()*Tile.TILE_HEIGHT;
            game.getPanelManager().addObject(new TemporalPanel(new PiecePanel(this,e.getX(),e.getY(),200, 300),700));
            game.getWorld().getCloneList().forEach(tile -> {tile.setDistance(Integer.MAX_VALUE);
                                                                                 tile.setShortestPath(new LinkedList<>());});
            game.getWorld().calculateShortestPathFromSource(game.getWorld().findTilesPieceOnWorld(this));

        } else if(e.getButton() == MouseEvent.BUTTON3) {
            if(game.selectedObject.isItem()) {
                PlayableAction.USE_ITEM.execute(this);
            } else if(game.selectedObject.isPiece()) {
                PlayableAction.ATTACK.execute(this);
            } else if(game.selectedObject.isCard()) {
                //TODO
            }
        } 
        
        

    }

    @Override
    public boolean isPiece() {
        return true;
    }


    @Override
    public Piece getPiece() {
        return this;
    }

    @Override
    public boolean isCard() {
        return false;
    }

    @Override
    public boolean isItem() {
        return false;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public Item getItem() {
        return null;
    }

    public PieceStats getStats() {
        return stats;
    }
   
    public static final class King extends Piece {
        
        public King(final Piece piece) {
            super(piece);
            applyKingStats();
        }
        
        public void applyKingStats() {
            stats.addMod(Buff.KING_BUFF);
        }

        @Override
        public void setAlliance(Alliance alliance) {
            super.setAlliance(alliance);
        }
    }
    
    
    private static class Builder {
        
        private Game game;
        private String name;

        private Element element;
        private Health health;
        private Damage damage;
        private Armor armor;
        private ElementalDamage elementalDamage;
        private ElementalArmor elementalDeffense;
        private Moves moves;
        private CriticalChance criticChance;
        private BlockChance blockChance;
        private LifeSteal lifeSteal;
        private ArmorPenetration armorPenetration;
        
        private PieceStats pieceStats;
        
        private BufferedImage image;
        
        public Builder(final Game game) {
            this.game = game;
            this.name = "New Piece";
            this.health = new Health(100,100);
            this.damage = new Damage(10);
            this.armor = new Armor(5);
            this.elementalDamage = new ElementalDamage(10);
            this.elementalDeffense = new ElementalArmor(5);
            this.moves = new Moves(3);
            this.criticChance = new CriticalChance(0);
            this.blockChance = new BlockChance(0);
            this.lifeSteal = new LifeSteal(0);
            this.armorPenetration = new ArmorPenetration(0);
            this.pieceStats = new PieceStats(health, damage,armor,elementalDamage,
                    elementalDeffense,criticChance, blockChance,
                    lifeSteal, armorPenetration, moves);
            this.element = Element.EARTH;
            this.image = Assets.PIECE_0001;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxHealth(float health) {
            this.health.setMaxValue(health);
            return this;
        }
        
        public Builder setHealth(float health) {
            this.health.setValue(health);
            setMaxHealth(health);
            return this;
        }

        public Builder setDamage(float damage) {
            this.damage.setValue(damage);
            return this;
        }

        public Builder setArmor(float armor) {
            this.armor.setValue(armor);
            return this;
        }

        public Builder setElement(Element element) {
            this.element = element;
            return this;
        }

        public Builder setElementalDamage(float elementalDamage) {
            this.elementalDamage.setValue(elementalDamage);
            return this;
        }

        public Builder setElementalArmor(float elementalArmor) {
            this.elementalDeffense.setValue(elementalArmor);
            return this;
        }
        public Builder setCriticalChance(float critChance) {
            this.criticChance.setValue(critChance);
            return this;
        }
        public Builder setBlockChance(float blockChance) {
            this.blockChance.setValue(blockChance);
            return this;
        }
        public Builder setLifeSteal(float lifeSteal) {
            this.lifeSteal.setValue(lifeSteal);
            return this;
        }
        public Builder setArmorPenetration(float arpen) {
            this.armorPenetration.setValue(arpen);
            return this;
        }
        
        public Builder setMoves(float moves) {
            this.moves.setValue(moves);
            return this;
        }
        public Builder setImage(BufferedImage bi) {
            this.image = bi;
            return this;
        }
        
        public Piece build() {
            this.pieceStats = new PieceStats(health, damage,armor,elementalDamage,
                    elementalDeffense, criticChance, blockChance,
                    lifeSteal, armorPenetration, moves);
            return new Piece(this);
        }
        
    }
    
    
}
