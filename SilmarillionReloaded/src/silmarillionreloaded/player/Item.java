/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import com.google.common.collect.ImmutableList;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import silmarillion.renderableObjects.Panel.ItemPanel;
import silmarillion.renderableObjects.RenderableObject;
import silmarillion.renderableObjects.TemporalPanel;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.pieces.PieceModifier;

/**
 *
 * @author Ferran
 */
public class Item extends RenderableObject implements PieceModifier {
    
    public final static int ITEM_WIDTH = Inventory.INVENTORY_WIDTH / Inventory.COLUMNS;
    public final static int ITEM_HEIGHT = Inventory.INVENTORY_HEIGHT / Inventory.ROWS ;
    
    private static final List<Item> ITEMS_CACHE = new ArrayList<>();
    
    public static Item getNewRandomItemOrNot() {
        
        Random random = new Random();
        List<Item> allItems = ImmutableList.copyOf(ITEMS_CACHE);
        Collections.shuffle(allItems);
        for(Item item : allItems) {
            if(item.proc > random.nextFloat()*100) {
                return item;
            }
        }
        return null;
    }
    
    public static Item MAP, GREAT_AXE, AXE, HAMMER, GREAT_SHIELD, SHIELD, 
                        PERGAMIN, STAFF, BAG, GREAT_DOUBLE_AXE, DOUBLE_AXE, 
                        CHEST, BOW, WOODEN_SWORD, TOOLS, GREAT_SWORD, SWORD, 
                        HELM, HEART, BOOK, GREEN_GEM, BLUE_GEM, 
                        RED_GEM, GREEN_POTION, BLUE_POTION, RED_POTION;
    
    public static void init() {
        Builder builder = new Builder();
        
        builder.resetBuilder("Map");
        builder.setImage(Assets.MAP);
        builder.setMovesMod(3);
        builder.setProc(1f);
        MAP = builder.build();
        
        builder.resetBuilder("Great Axe");
        builder.setImage(Assets.GREAT_AXE);
        builder.setDamageMod(50);
        builder.setProc(1f);
        GREAT_AXE = builder.build();
        
        builder.resetBuilder("Axe");
        builder.setImage(Assets.AXE);
        builder.setDamageMod(40);
        builder.setProc(1f);
        AXE = builder.build();
        
        builder.resetBuilder("Hammer");
        builder.setImage(Assets.HAMMER);
        builder.setDamageMod(30);
        builder.setArmorMod(10);
        builder.setProc(1f);
        HAMMER = builder.build();
        
        builder.resetBuilder("Great shield");
        builder.setImage(Assets.GREAT_SHIELD);
        builder.setArmorMod(10);
        builder.setProc(1f);
        GREAT_SHIELD = builder.build();
        
        builder.resetBuilder("Shield");
        builder.setImage(Assets.SHIELD);
        builder.setArmorMod(5);
        builder.setProc(1f);
        SHIELD = builder.build(); 
        
        builder.resetBuilder("Pergamin");
        builder.setImage(Assets.PERGAMIN);
        builder.setMovesMod(1);
        builder.setProc(1f);
        PERGAMIN = builder.build();
        
        builder.resetBuilder("Staff");
        builder.setImage(Assets.STAFF);
        builder.setElementalDamageMod(100);
        builder.setProc(1f);
        STAFF = builder.build();
        
        builder.resetBuilder("Bag");
        builder.setImage(Assets.BAG);
        builder.setMovesMod(2);
        builder.setProc(1f);
        BAG = builder.build();
        
        builder.resetBuilder("Great Double Axe");
        builder.setImage(Assets.GREAT_DOUBLE_AXE);
        builder.setDamageMod(100);
        builder.setProc(1f);
        GREAT_DOUBLE_AXE = builder.build();
        
        builder.resetBuilder("Double Axe");
        builder.setImage(Assets.DOUBLE_AXE);
        builder.setDamageMod(75);
        builder.setProc(1f);
        DOUBLE_AXE = builder.build(); 
        
        builder.resetBuilder("Chest");
        builder.setImage(Assets.CHEST);
        builder.setArmorMod(20);
        builder.setProc(1f);
        CHEST = builder.build();
        
        builder.resetBuilder("Bow");
        builder.setImage(Assets.BOW);
        builder.setDamageMod(10);
        builder.setArmorMod(10);
        builder.setProc(1f);
        BOW = builder.build();
        
        builder.resetBuilder("Wooder Sword");
        builder.setImage(Assets.WOODEN_SWORD);
        builder.setDamageMod(10);
        builder.setProc(1f);
        WOODEN_SWORD = builder.build();
        
        builder.resetBuilder("Tools");
        builder.setImage(Assets.TOOLS);
        builder.setDamageMod(30);
        builder.setArmorMod(10);
        builder.setProc(1f);
        TOOLS = builder.build();
        
        builder.resetBuilder("Great Sword");
        builder.setImage(Assets.GREAT_SWORD);
        builder.setDamageMod(30);
        builder.setProc(1f);
        GREAT_SWORD = builder.build();
        
        builder.resetBuilder("Sword");
        builder.setImage(Assets.SWORD);
        builder.setDamageMod(20);
        builder.setProc(1f);
        SWORD = builder.build(); 
        
        builder.resetBuilder("Helm");
        builder.setImage(Assets.HELM);
        builder.setArmorMod(15);
        builder.setProc(1f);
        HELM = builder.build();
        
        builder.resetBuilder("Heart");
        builder.setImage(Assets.HEART);
        builder.setHealthMod(100);
        builder.setProc(1f);
        HEART = builder.build();
        
        builder.resetBuilder("Book");
        builder.setImage(Assets.BOOK);
        builder.setElementalArmorMod(20);
        builder.setProc(1f);
        BOOK = builder.build();
        
        builder.resetBuilder("Green Gem");
        builder.setImage(Assets.GREEN_GEM);
        builder.setElementalDamageMod(50);
        builder.setProc(1f);
        GREEN_GEM = builder.build();
        
        builder.resetBuilder("Blue Gem");
        builder.setImage(Assets.BLUE_GEM);
        builder.setElementalDamageMod(75);
        builder.setProc(1f);
        BLUE_GEM = builder.build();
        
        builder.resetBuilder("Red Gem");
        builder.setImage(Assets.RED_GEM);
        builder.setElementalDamageMod(25);
        builder.setProc(1f);
        RED_GEM = builder.build();
        
        builder.resetBuilder("Green Potion");
        builder.setImage(Assets.GREEN_POTION);
        builder.setElementalArmorMod(10);
        builder.setProc(1f);
        GREEN_POTION = builder.build();
        
        builder.resetBuilder("Blue Potion");
        builder.setImage(Assets.BLUE_POTION);
        builder.setElementalArmorMod(15);
        builder.setProc(1f);
        BLUE_POTION = builder.build();
        
        builder.resetBuilder("Red Potion");
        builder.setImage(Assets.RED_POTION);
        builder.setElementalArmorMod(5);
        builder.setProc(1f);
        RED_POTION = builder.build();
        
        ITEMS_CACHE.add(MAP);
        ITEMS_CACHE.add(GREAT_AXE);
        ITEMS_CACHE.add(AXE);
        ITEMS_CACHE.add(HAMMER);
        ITEMS_CACHE.add(GREAT_SHIELD);
        ITEMS_CACHE.add(SHIELD);
        ITEMS_CACHE.add(PERGAMIN);
        ITEMS_CACHE.add(STAFF);
        ITEMS_CACHE.add(BAG);
        ITEMS_CACHE.add(GREAT_DOUBLE_AXE);
        ITEMS_CACHE.add(DOUBLE_AXE);
        ITEMS_CACHE.add(CHEST);
        ITEMS_CACHE.add(BOW);
        ITEMS_CACHE.add(WOODEN_SWORD);
        ITEMS_CACHE.add(TOOLS);
        ITEMS_CACHE.add(GREAT_SWORD);
        ITEMS_CACHE.add(SWORD);
        ITEMS_CACHE.add(HELM);
        ITEMS_CACHE.add(HEART);
        ITEMS_CACHE.add(BOOK);
        ITEMS_CACHE.add(GREEN_GEM);
        ITEMS_CACHE.add(BLUE_GEM); 
        ITEMS_CACHE.add(RED_GEM);
        ITEMS_CACHE.add(GREEN_POTION);
        ITEMS_CACHE.add(BLUE_POTION);
        ITEMS_CACHE.add(RED_POTION);
    }
    
    
    private final String name;
    private final BufferedImage image;
    private final int healthMod;
    private final int damageMod;
    private final int armorMod;
    private final int elementalDamageMod;
    private final int elementalArmorMod;
    private final int movesMod;
    private final float proc;
    
    
    private Item(final Builder builder) {
        super(ITEM_WIDTH, ITEM_HEIGHT);
        name = builder.name;
        image = builder.image;
        healthMod = builder.healthMod;
        damageMod = builder.damageMod;
        armorMod = builder.armorMod;
        elementalDamageMod = builder.elementalDamageMod;
        elementalArmorMod = builder.elementalArmorMod;
        movesMod = builder.movesMod;
        proc = builder.proc;
    }

    public Item(Item item) {
        super(ITEM_WIDTH, ITEM_HEIGHT);
        name = item.name;
        image = item.image;
        healthMod = item.healthMod;
        damageMod = item.damageMod;
        armorMod = item.armorMod;
        elementalDamageMod = item.elementalDamageMod;
        elementalArmorMod = item.elementalArmorMod;
        movesMod = item.movesMod;
        proc = item.proc;
    }
    
    
    public String getName() {
        return name;
    }
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g, float x, float y) {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        Game.INSTANCE.getPanelManager().addObject(new TemporalPanel(new ItemPanel(this,(int)e.getX(),(int)e.getY(),180,60),1500));
    }

    @Override
    public int moddifyHealth() {
        return healthMod;
    }

    @Override
    public int moddifyDamage() {
        return damageMod;
    }

    @Override
    public int moddifyArmor() {
        return armorMod;
    }

    @Override
    public int moddifyElementalDamage() {
        return elementalDamageMod;
    }

    @Override
    public int moddifyElementalArmor() {
        return elementalArmorMod;
    }

    @Override
    public int moddifyMoves() {
        return movesMod;
    }
    
    
    private static class Builder {
        private String name;
        private BufferedImage image;
        private int healthMod;
        private int damageMod;
        private int armorMod;
        private int elementalDamageMod;
        private int elementalArmorMod;
        private int movesMod;
        private float proc;
        
        public Builder() {
            name = "New Item";
            image = Assets.CROSS;
            healthMod = 0;
            damageMod = 0;
            armorMod = 0;
            elementalDamageMod = 0;
            elementalArmorMod = 0;
            movesMod = 0;
            proc = 0;
        }

        public Builder resetBuilder(String name) {
            this.name = name;
            image = Assets.CROSS;
            healthMod = 0;
            damageMod = 0;
            armorMod = 0;
            elementalDamageMod = 0;
            elementalArmorMod = 0;
            movesMod = 0;
            proc = 0;
            return this;
        }
        
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setImage(BufferedImage image) {
            this.image = image;
            return this;
        }

        public Builder setHealthMod(int healthMod) {
            this.healthMod = healthMod;
            return this;
        }

        public Builder setDamageMod(int damageMod) {
            this.damageMod = damageMod;
            return this;
        }

        public Builder setArmorMod(int armorMod) {
            this.armorMod = armorMod;
            return this;
        }

        public Builder setElementalDamageMod(int elementalDamageMod) {
            this.elementalDamageMod = elementalDamageMod;
            return this;
        }

        public Builder setElementalArmorMod(int elementalArmorMod) {
            this.elementalArmorMod = elementalArmorMod;
            return this;
        }

        public Builder setMovesMod(int movesMod) {
            this.movesMod = movesMod;
            return this;
        }
        
        public Builder setProc(float proc) {
            this.proc = proc;
            return this;
        }
        
        public Item build() {
            return new Item(this);
        }
        
        
    }

}
