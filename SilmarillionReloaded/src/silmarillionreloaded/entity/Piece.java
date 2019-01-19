/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import silmarillionreloaded.Application;
import silmarillionreloaded.gfx.Assets;

/**
 *
 * @author Ferran
 */
public class Piece extends Entity {
    
    private final String name;
    private final Stat health;
    private final Stat damage;
    private final Stat armor;
    private final Element element;
    private final Stat elementalDamage;
    private final Stat elementalArmor;
    private final Stat moves;
    
    private final BufferedImage image;
    
    public Piece(Application app, float x, float y, int width, int height, Builder builder) {
        super(app, x, y, width, height);
        name = builder.name;
        health = builder.health;
        damage = builder.damage;
        armor = builder.armor;
        element = builder.element;
        elementalDamage = builder.elementalDamage;
        elementalArmor = builder.elementalArmor;
        moves = builder.moves;
        image = builder.image;
    }
    
    public boolean isAlive() {
        return health.getValue() <= 0;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private class Builder {
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
    }
    
    
}
