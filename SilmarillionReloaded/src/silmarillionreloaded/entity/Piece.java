/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import silmarillionreloaded.entity.actions.Caster;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class Piece extends Entity implements Target,Caster{
    
    public static List<Piece> PIECES_CACHE;
    
    public static void init() {
        PIECES_CACHE = new ArrayList<>();
        Builder builder = new Builder();
        builder.setName("Test Piece");
        PIECES_CACHE.add(builder.build());
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
    
    public Piece(Piece piece, Alliance alliance, int x, int y, int width, int height) {
        super(x, y, width, height);
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
        super(0, 0, 0, 0);
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
    
    private void setBounds(int x, int y, int width, int height) {
        setSize(width,height);
        setPosition(x,y);
    }
    private void setPosition(int x, int y) {
        super.x = x;
        super.y = y;
    }
    private void setSize(int widht, int height) {
        super.width = width;
        super.height = height;
    }
    
    public boolean isAlive() {
        return health.getValue() <= 0;
    }

    public Alliance getAlliance() {
        return alliance;
    }
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
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
        public Piece build() {
            return new Piece(this);
        }
        
    }
    
    
}
