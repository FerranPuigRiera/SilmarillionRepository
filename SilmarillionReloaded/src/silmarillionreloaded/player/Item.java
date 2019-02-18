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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import silmarillionreloaded.renderableObjects.Panel.ItemPanel;
import silmarillionreloaded.renderableObjects.RenderableObject;
import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.game.ObjectSelected;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.pieces.PieceModifier;
import silmarillionreloaded.player.Item.Weapon.Axe;
import silmarillionreloaded.player.Item.Weapon.Mace;
import silmarillionreloaded.player.Item.Weapon.Spear;
import silmarillionreloaded.player.Item.Weapon.Sword;

/**
 *
 * @author Ferran
 */
public class Item extends RenderableObject implements ObjectSelected, PieceModifier {

    public final static int ITEM_WIDTH = 40;
    public final static int ITEM_HEIGHT = 40;
    
    private static final List<Item> ITEMS_CACHE = new ArrayList<>();
    
    public static Item getNewRandomItemOrNot() {
        
        Random random = new Random();
        List<Item> allItems = ITEMS_CACHE;
        Collections.shuffle(allItems);
        for(Item item : allItems) {
            if(item.proc > random.nextFloat()*100) {
                return new Item(item);
            }
        }
        return null;
    }
    
    public static Item FOOD_1, FOOD_2, FOOD_3, FOOD_4, FOOD_5, FOOD_6, FOOD_7, FOOD_8, FOOD_9, FOOD_10, FOOD_11, FOOD_12, FOOD_13, FOOD_14,
                        FOOD_15, FOOD_16, FOOD_17, FOOD_18, FOOD_19, FOOD_20, FOOD_21, FOOD_22, FOOD_23, FOOD_24, FOOD_25, FOOD_26, FOOD_27, FOOD_28,
                        BIG_ELIXIR_RED, BIG_ELIXIR_ORANGE, BIG_ELIXIR_YELLOW, BIG_ELIXIR_BLUE, BIG_ELIXIR_PURPLE, BIG_ELIXIR_GREEN, BIG_ELIXIR_GREY, 
                        SMALL_ELIXIR_RED, SMALL_ELIXIR_ORANGE, SMALL_ELIXIR_YELLOW, SMALL_ELIXIR_BLUE, SMALL_ELIXIR_PURPLE, SMALL_ELIXIR_GREEN, SMALL_ELIXIR_GREY,
                        SWORD_1, SWORD_2, SWORD_3, SWORD_4, SWORD_5, SWORD_6, SWORD_7, SWORD_8, SWORD_9, SWORD_10, SWORD_11, SWORD_12, SWORD_13, SWORD_14,
                        SPEAR_1, SPEAR_2, SPEAR_3, SPEAR_4, SPEAR_5, SPEAR_6, SPEAR_7, SPEAR_8, SPEAR_9, SPEAR_10, SPEAR_11, SPEAR_12, SPEAR_13, SPEAR_14,
                        MACE_1, MACE_2, MACE_3, MACE_4, MACE_5, MACE_6, MACE_7, MACE_8, MACE_9, MACE_10, MACE_11, MACE_12, MACE_13, MACE_14,
                        AXE_1, AXE_2, AXE_3, AXE_4, AXE_5, AXE_6, AXE_7, AXE_8, AXE_9, AXE_10, BOOK_1, BOOK_2, BOOK_3, BOOK_4,
                        SHIELD_1, SHIELD_2, SHIELD_3, SHIELD_4, SHIELD_5, SHIELD_6, SHIELD_7, SHIELD_8, SHIELD_9, SHIELD_10, SHIELD_11, SHIELD_12, SHIELD_13, SHIELD_14,
                        GEM_1, GEM_2, GEM_3, GEM_4, GEM_5, GEM_6, GEM_7, GEM_8, GEM_9, GEM_10, GEM_11, GEM_12, GEM_13, GEM_14,
                        CRAP_1, CRAP_2, CRAP_3, CRAP_4, CRAP_5, CRAP_6, CRAP_7, CRAP_8, CRAP_9, CRAP_10, CRAP_11, CRAP_12, CRAP_13, CRAP_14,
                        CHEST_1, CHEST_2, CHEST_3, CHEST_4, TORCH_FLAME, TORCH, KEY_1, KEY_2, KEY_3, KEY_4, KEY_5, KEY_6, KEY_7, KEY_8,
                        HELM_1, HELM_2, HELM_3, HELM_4, HELM_5, MIRROR, FEATHER_1, FEATHER_2, CHAIN, POISON, BAG, PAPER_1, PAPER_2, PAPER_3,
                        TRINKET_1, TRINKET_2, TRINKET_3, TRINKET_4, TRINKET_5, TRINKET_6, TRINKET_7, TRINKET_8, TRINKET_9, TRINKET_10, GLOVE_1, GLOVE_2, GLOVE_3, GLOVE_4,
                        OTHER_1, OTHER_2, OTHER_3, OTHER_4, OTHER_5, OTHER_6, OTHER_7, OTHER_8, OTHER_9, OTHER_10, OTHER_11, OTHER_12, OTHER_13, OTHER_14,
                        OTHER_15, OTHER_16, OTHER_17, OTHER_18, OTHER_19, OTHER_20, OTHER_21, OTHER_22, OTHER_23, OTHER_24, OTHER_25, OTHER_26, OTHER_27, OTHER_28;
    
    
    public static void init(final Game game) {
        
        FOOD_1 = new Food(game, "Blueberry", Assets.FOOD_1, 0.1f , 1);
        ITEMS_CACHE.add(FOOD_1);
        FOOD_2 = new Food(game, "Cherry", Assets.FOOD_2, 0.1f ,2);
        ITEMS_CACHE.add(FOOD_2);
        FOOD_3 = new Food(game, "Green apple", Assets.FOOD_3 , 0.1f ,3);
        ITEMS_CACHE.add(FOOD_3);
        FOOD_4 = new Food(game, "Red apple", Assets.FOOD_4 , 0.1f, 4);
        ITEMS_CACHE.add(FOOD_4);
        FOOD_5 = new Food(game, "Orange", Assets.FOOD_5 , 0.1f, 5);
        ITEMS_CACHE.add(FOOD_5);
        FOOD_6 = new Food(game, "Green grape", Assets.FOOD_6 , 0.1f, 6);
        ITEMS_CACHE.add(FOOD_6);
        FOOD_7 = new Food(game, "Blue grape", Assets.FOOD_7 , 0.1f, 7);
        ITEMS_CACHE.add(FOOD_7);
        FOOD_8 = new Food(game, "Watermelon", Assets.FOOD_8 , 0.1f, 8);
        ITEMS_CACHE.add(FOOD_8);
        FOOD_9 = new Food(game, "Strawberry", Assets.FOOD_9 , 0.1f, 9);
        ITEMS_CACHE.add(FOOD_9);
        FOOD_10 = new Food(game, "Pear", Assets.FOOD_10 , 0.1f, 10);
        ITEMS_CACHE.add(FOOD_10);
        FOOD_11 = new Food(game, "Lemon", Assets.FOOD_11 , 0.1f, 11);
        ITEMS_CACHE.add(FOOD_11);
        FOOD_12 = new Food(game, "Pineapple", Assets.FOOD_12 , 0.1f, 12);
        ITEMS_CACHE.add(FOOD_12);
        FOOD_13 = new Food(game, "Bannana", Assets.FOOD_13 , 0.1f, 13);
        ITEMS_CACHE.add(FOOD_13);
        FOOD_14 = new Food(game, "Acorn", Assets.FOOD_14 , 0.1f, 14);
        ITEMS_CACHE.add(FOOD_14);
        FOOD_15 = new Food(game, "Radish", Assets.FOOD_15 , 0.1f, 15);
        ITEMS_CACHE.add(FOOD_15);
        FOOD_16 = new Food(game, "Carrot", Assets.FOOD_16 , 0.1f, 16);
        ITEMS_CACHE.add(FOOD_16);
        FOOD_17 = new Food(game, "Green peeper", Assets.FOOD_17 , 0.1f, 17);
        ITEMS_CACHE.add(FOOD_17);
        FOOD_18 = new Food(game, "Yellow peeper", Assets.FOOD_18 , 0.1f, 18);
        ITEMS_CACHE.add(FOOD_18);
        FOOD_19 = new Food(game, "Red peeper", Assets.FOOD_19 , 0.1f, 19);
        ITEMS_CACHE.add(FOOD_19);
        FOOD_20 = new Food(game, "Mushrom", Assets.FOOD_20 , 0.1f, 20);
        ITEMS_CACHE.add(FOOD_20);
        FOOD_21 = new Food(game, "Eggs", Assets.FOOD_21 , 0.1f, 21);
        ITEMS_CACHE.add(FOOD_21);
        FOOD_22 = new Food(game, "Bread", Assets.FOOD_22 , 0.1f, 22);
        ITEMS_CACHE.add(FOOD_22);
        FOOD_23 = new Food(game, "Cake", Assets.FOOD_23 , 0.1f, 23);
        ITEMS_CACHE.add(FOOD_23);
        FOOD_24 = new Food(game, "Cheese", Assets.FOOD_24 , 0.1f, 24);
        ITEMS_CACHE.add(FOOD_24);
        FOOD_25 = new Food(game, "Fish", Assets.FOOD_25 , 0.1f, 25);
        ITEMS_CACHE.add(FOOD_25);
        FOOD_26 = new Food(game, "Meet", Assets.FOOD_26 , 0.1f, 26); 
        ITEMS_CACHE.add(FOOD_26);
        FOOD_27 = new Food(game, "Roosted fish", Assets.FOOD_27 , 0.1f, 27);
        ITEMS_CACHE.add(FOOD_27);
        FOOD_28 = new Food(game, "Roosted meet", Assets.FOOD_28 , 0.1f, 28);
        ITEMS_CACHE.add(FOOD_28);
        BIG_ELIXIR_RED = new Elixir(game, "Great health potion", Assets.BIG_ELIXIR_RED , 0.1f, "BIG", "RED");
        ITEMS_CACHE.add(BIG_ELIXIR_RED);
        BIG_ELIXIR_ORANGE = new Elixir(game, "Great attack potion", Assets.BIG_ELIXIR_ORANGE , 0.1f, "BIG", "ORANGE");
        ITEMS_CACHE.add(BIG_ELIXIR_ORANGE);
        BIG_ELIXIR_YELLOW = new Elixir(game, "Great deffense potion", Assets.BIG_ELIXIR_YELLOW , 0.1f, "BIG", "YELLOW"); 
        ITEMS_CACHE.add(BIG_ELIXIR_YELLOW);
        BIG_ELIXIR_BLUE = new Elixir(game, "Great elemental attack potion", Assets.BIG_ELIXIR_BLUE , 0.1f, "BIG", "BLUE");
        ITEMS_CACHE.add(BIG_ELIXIR_BLUE);
        BIG_ELIXIR_PURPLE = new Elixir(game, "Great elemental armor potion", Assets.BIG_ELIXIR_PURPLE , 0.1f, "BIG", "PURPLE");
        ITEMS_CACHE.add(BIG_ELIXIR_PURPLE);
        BIG_ELIXIR_GREEN = new Elixir(game, "Grat agility potion", Assets.BIG_ELIXIR_GREEN , 0.1f, "BIG", "GREEN");
        ITEMS_CACHE.add(BIG_ELIXIR_GREEN);
        SMALL_ELIXIR_RED = new Elixir(game, "Health potion", Assets.SMALL_ELIXIR_RED , 0.1f, "SMALL", "GREY");
        ITEMS_CACHE.add(SMALL_ELIXIR_RED);
        SMALL_ELIXIR_ORANGE = new Elixir(game, "Attack potion", Assets.SMALL_ELIXIR_ORANGE , 0.1f, "SMALL", "ORANGE");
        ITEMS_CACHE.add(SMALL_ELIXIR_ORANGE);
        SMALL_ELIXIR_YELLOW = new Elixir(game, "Deffense potion", Assets.SMALL_ELIXIR_YELLOW , 0.1f, "SMALL", "YELLOW");
        ITEMS_CACHE.add(SMALL_ELIXIR_YELLOW);
        SMALL_ELIXIR_BLUE = new Elixir(game, "Elemental attack potion", Assets.SMALL_ELIXIR_BLUE , 0.1f, "SMALL", "BLUE");
        ITEMS_CACHE.add(SMALL_ELIXIR_BLUE);
        SMALL_ELIXIR_PURPLE = new Elixir(game, "Elemental armor potion", Assets.SMALL_ELIXIR_PURPLE , 0.1f, "SMALL", "PURPLE"); 
        ITEMS_CACHE.add(SMALL_ELIXIR_PURPLE);
        SMALL_ELIXIR_GREEN = new Elixir(game, "Agility potion", Assets.SMALL_ELIXIR_GREEN , 0.1f, "SMALL", "GREEN"); 
        ITEMS_CACHE.add(SMALL_ELIXIR_GREEN);
        SWORD_1 = new Sword(game, "Sowrd 1", Assets.SWORD_1 , 0.1f,1);
        ITEMS_CACHE.add(SWORD_1);
        SWORD_2 = new Sword(game, "Sword 2", Assets.SWORD_2 , 0.1f,2);
        ITEMS_CACHE.add(SWORD_2);
        SWORD_3 = new Sword(game, "Sword 3", Assets.SWORD_3 , 0.1f,3);
        ITEMS_CACHE.add(SWORD_3);
        SWORD_4 = new Sword(game, "Sword 4", Assets.SWORD_4 , 0.1f,4); 
        ITEMS_CACHE.add(SWORD_4);
        SWORD_5 = new Sword(game, "Sword 5", Assets.SWORD_5 , 0.1f,5); 
        ITEMS_CACHE.add(SWORD_5);
        SWORD_6 = new Sword(game, "Sword 6", Assets.SWORD_6 , 0.1f,6); 
        ITEMS_CACHE.add(SWORD_6);
        SWORD_7 = new Sword(game, "Sword 7", Assets.SWORD_7 , 0.1f,7); 
        ITEMS_CACHE.add(SWORD_7);
        SWORD_8 = new Sword(game, "Sword 8", Assets.SWORD_8 , 0.1f,8); 
        ITEMS_CACHE.add(SWORD_8);
        SWORD_9 = new Sword(game, "Sword 9", Assets.SWORD_9 , 0.1f,9);
        ITEMS_CACHE.add(SWORD_9);
        SWORD_10 = new Sword(game, "Sword 10", Assets.SWORD_10 , 0.1f,10);
        ITEMS_CACHE.add(SWORD_10);
        SWORD_11 = new Sword(game, "Sword 11", Assets.SWORD_11 , 0.1f,11); 
        ITEMS_CACHE.add(SWORD_11);
        SWORD_12 = new Sword(game, "Sword 12", Assets.SWORD_1 , 0.1f,12); 
        ITEMS_CACHE.add(SWORD_12);
        SWORD_13 = new Sword(game, "Sword 13", Assets.SWORD_12 , 0.1f,13);
        ITEMS_CACHE.add(SWORD_13);
        SWORD_14 = new Sword(game, "Sword 14", Assets.SWORD_14 , 0.1f,14);
        ITEMS_CACHE.add(SWORD_14);
        SPEAR_1 = new Spear(game, "Dagger 1", Assets.SPEAR_1 , 0.1f,1); 
        ITEMS_CACHE.add(SPEAR_1);
        SPEAR_2 = new Spear(game, "Dagger 2", Assets.SPEAR_2 , 0.1f,2);
        ITEMS_CACHE.add(SPEAR_2);
        SPEAR_3 = new Spear(game, "Dagger 3", Assets.SPEAR_3 , 0.1f,3); 
        ITEMS_CACHE.add(SPEAR_3);
        SPEAR_4 = new Spear(game, "Dagger 4", Assets.SPEAR_4 , 0.1f,4); 
        ITEMS_CACHE.add(SPEAR_4);
        SPEAR_5 = new Spear(game, "Dagger 5", Assets.SPEAR_5 , 0.1f,5); 
        ITEMS_CACHE.add(SPEAR_5); 
        SPEAR_6 = new Spear(game, "Dagger 6", Assets.SPEAR_6 , 0.1f,6); 
        ITEMS_CACHE.add(SPEAR_6);
        SPEAR_7 = new Spear(game, "Dagger 7", Assets.SPEAR_7 , 0.1f,7);
        ITEMS_CACHE.add(SPEAR_7); 
        SPEAR_8 = new Spear(game, "Spear 1", Assets.SPEAR_8 , 0.1f,8); 
        ITEMS_CACHE.add(SPEAR_8); 
        SPEAR_9 = new Spear(game, "Spear 2", Assets.SPEAR_9 , 0.1f,9); 
        ITEMS_CACHE.add(SPEAR_9); 
        SPEAR_10 = new Spear(game, "Spear 3", Assets.SPEAR_10 , 0.1f,10); 
        ITEMS_CACHE.add(SPEAR_10); 
        SPEAR_11 = new Spear(game, "Spear 4", Assets.SPEAR_11 , 0.1f,11); 
        ITEMS_CACHE.add(SPEAR_11); 
        SPEAR_12 = new Spear(game, "Spear 5", Assets.SPEAR_12 , 0.1f,12); 
        ITEMS_CACHE.add(SPEAR_12);
        SPEAR_13 = new Spear(game, "Spear 6", Assets.SPEAR_13 , 0.1f,13); 
        ITEMS_CACHE.add(SPEAR_13);
        SPEAR_14 = new Spear(game, "Spear 7", Assets.SPEAR_14 , 0.1f,14); 
        ITEMS_CACHE.add(SPEAR_14);
        MACE_1 = new Mace(game, "Mace 1", Assets.MACE_1 , 0.1f,1); 
        ITEMS_CACHE.add(MACE_1);
        MACE_2 = new Mace(game, "Mace 2", Assets.MACE_2 , 0.1f,2); 
        ITEMS_CACHE.add(MACE_2);
        MACE_3 = new Mace(game, "Mace 3", Assets.MACE_3 , 0.1f,3); 
        ITEMS_CACHE.add(MACE_3);
        MACE_4 = new Mace(game, "Mace 4", Assets.MACE_4 , 0.1f,4); 
        ITEMS_CACHE.add(MACE_4); 
        MACE_5 = new Mace(game, "Mace 5", Assets.MACE_5 , 0.1f,5);
        ITEMS_CACHE.add(MACE_5);
        MACE_6 = new Mace(game, "Mace 6", Assets.MACE_6 , 0.1f,6);
        ITEMS_CACHE.add(MACE_6);
        MACE_7 = new Mace(game, "Mace 7", Assets.MACE_7 , 0.1f,7); 
        ITEMS_CACHE.add(MACE_7);
        MACE_8 = new Mace(game, "Mace 8", Assets.MACE_8 , 0.1f,8);
        ITEMS_CACHE.add(MACE_8);
        MACE_9 = new Mace(game, "Mace 9", Assets.MACE_9 , 0.1f,9); 
        ITEMS_CACHE.add(MACE_9); 
        MACE_10 = new Mace(game, "Mace 10", Assets.MACE_10 , 0.1f,10); 
        ITEMS_CACHE.add(MACE_10); 
        MACE_11 = new Mace(game, "Mace 11", Assets.MACE_11 , 0.1f,11); 
        ITEMS_CACHE.add(MACE_11);
        MACE_12 = new Mace(game, "Mace 12", Assets.MACE_12 , 0.1f,12); 
        ITEMS_CACHE.add(MACE_12);
        MACE_13 = new Mace(game, "Mace 13", Assets.MACE_13 , 0.1f,13); 
        ITEMS_CACHE.add(MACE_13); 
        MACE_14 = new Mace(game, "Mace 14", Assets.MACE_14 , 0.1f,14); 
        ITEMS_CACHE.add(MACE_14);
        AXE_1 = new Axe(game, "Axe 1", Assets.AXE_1 , 0.1f, 1); 
        ITEMS_CACHE.add(AXE_1);
        AXE_2 = new Axe(game, "Axe 2", Assets.AXE_2 , 0.1f, 2); 
        ITEMS_CACHE.add(AXE_2); 
        AXE_3 = new Axe(game, "Axe 3", Assets.AXE_3 , 0.1f, 3); 
        ITEMS_CACHE.add(AXE_3);
        AXE_4 = new Axe(game, "Axe 4", Assets.AXE_4 , 0.1f, 4); 
        ITEMS_CACHE.add(AXE_4); 
        AXE_5 = new Axe(game, "Axe 5", Assets.AXE_5 , 0.1f, 5); 
        ITEMS_CACHE.add(AXE_5);
        AXE_6 = new Axe(game, "Axe 6", Assets.AXE_6 , 0.1f, 6); 
        ITEMS_CACHE.add(AXE_6);
        AXE_7 = new Axe(game, "Axe 7", Assets.AXE_7 , 0.1f, 7); 
        ITEMS_CACHE.add(AXE_7); 
        AXE_8 = new Axe(game, "Axe 8", Assets.AXE_8 , 0.1f, 8); 
        ITEMS_CACHE.add(AXE_8); 
        AXE_9 = new Axe(game, "Axe 9", Assets.AXE_9 , 0.1f, 9); 
        ITEMS_CACHE.add(AXE_9);
        AXE_10 = new Axe(game, "Axe 10", Assets.AXE_10 , 0.1f, 10); 
        ITEMS_CACHE.add(AXE_10);
        SHIELD_1 = new Shield(game, "Shield 1", Assets.SHIELD_1 , 0.1f, 1); 
        ITEMS_CACHE.add(SHIELD_1);
        SHIELD_2 = new Shield(game, "Shield 2", Assets.SHIELD_2 , 0.1f, 2); 
        ITEMS_CACHE.add(SHIELD_2);
        SHIELD_3 = new Shield(game, "Shield 3", Assets.SHIELD_3 , 0.1f, 3); 
        ITEMS_CACHE.add(SHIELD_3);
        SHIELD_4 = new Shield(game, "Shield 4", Assets.SHIELD_4 , 0.1f, 4); 
        ITEMS_CACHE.add(SHIELD_4);
        SHIELD_5 = new Shield(game, "Shield 5", Assets.SHIELD_5 , 0.1f, 5); 
        ITEMS_CACHE.add(SHIELD_5);
        SHIELD_6 = new Shield(game, "Shield 6", Assets.SHIELD_6 , 0.1f, 6); 
        ITEMS_CACHE.add(SHIELD_6);
        SHIELD_7 = new Shield(game, "Shield 7", Assets.SHIELD_7 , 0.1f, 7); 
        ITEMS_CACHE.add(SHIELD_7); 
        SHIELD_8 = new Shield(game, "Shield 8", Assets.SHIELD_8 , 0.1f, 8); 
        ITEMS_CACHE.add(SHIELD_8); 
        SHIELD_9 = new Shield(game, "Shield 9", Assets.SHIELD_9 , 0.1f, 9); 
        ITEMS_CACHE.add(SHIELD_9); 
        SHIELD_10 = new Shield(game, "Shield 10", Assets.SHIELD_10 , 0.1f, 10); 
        ITEMS_CACHE.add(SHIELD_10); 
        SHIELD_11 = new Shield(game, "Shield 11", Assets.SHIELD_11 , 0.1f, 11); 
        ITEMS_CACHE.add(SHIELD_11);
        SHIELD_12 = new Shield(game, "Shield 12", Assets.SHIELD_12 , 0.1f, 12); 
        ITEMS_CACHE.add(SHIELD_12); 
        SHIELD_13 = new Shield(game, "Shield 13", Assets.SHIELD_13 , 0.1f, 13); 
        ITEMS_CACHE.add(SHIELD_13);
        SHIELD_14 = new Shield(game, "Shield 14", Assets.SHIELD_14 , 0.1f, 14); 
        ITEMS_CACHE.add(SHIELD_14);
        CHEST_1 = new Chest(game, "Chest 1", Assets.CHEST_1 , 0.1f, 1); 
        ITEMS_CACHE.add(CHEST_1); 
        CHEST_2 = new Chest(game, "Chest 2", Assets.CHEST_2 , 0.1f, 2); 
        ITEMS_CACHE.add(CHEST_2);
        CHEST_3 = new Chest(game, "Chest 3", Assets.CHEST_3 , 0.1f, 3); 
        ITEMS_CACHE.add(CHEST_3); 
        CHEST_4 = new Chest(game, "Chest 4", Assets.CHEST_4 , 0.1f, 4); 
        ITEMS_CACHE.add(CHEST_4);
        HELM_1 = new Helm(game, "Helm 1", Assets.HELM_1 , 0.1f, 1); 
        ITEMS_CACHE.add(HELM_1);
        HELM_2 = new Helm(game, "Helm 2", Assets.HELM_2 , 0.1f, 2); 
        ITEMS_CACHE.add(HELM_2);
        HELM_3 = new Helm(game, "Helm 3", Assets.HELM_3 , 0.1f, 3); 
        ITEMS_CACHE.add(HELM_3);
        HELM_4 = new Helm(game, "Helm 4", Assets.HELM_4 , 0.1f, 4); 
        ITEMS_CACHE.add(HELM_4); 
        HELM_5 = new Helm(game, "Helm 5", Assets.HELM_5 , 0.1f, 5); 
        ITEMS_CACHE.add(HELM_5);
        TRINKET_1 = new Trinket(game, "Trinket 1", Assets.TRINKET_1 , 0.1f, 1); 
        ITEMS_CACHE.add(TRINKET_1);
        TRINKET_2 = new Trinket(game, "Trinket 2", Assets.TRINKET_2 , 0.1f, 2); 
        ITEMS_CACHE.add(TRINKET_2); 
        TRINKET_3 = new Trinket(game, "Trinket 3", Assets.TRINKET_3 , 0.1f, 3); 
        ITEMS_CACHE.add(TRINKET_3); 
        TRINKET_4 = new Trinket(game, "Trinket 4", Assets.TRINKET_4 , 0.1f, 4); 
        ITEMS_CACHE.add(TRINKET_4); 
        TRINKET_5 = new Trinket(game, "Trinket 5", Assets.TRINKET_5 , 0.1f, 5); 
        ITEMS_CACHE.add(TRINKET_5); 
        TRINKET_6 = new Trinket(game, "Trinket 6", Assets.TRINKET_6 , 0.1f, 6); 
        ITEMS_CACHE.add(TRINKET_6); 
        TRINKET_7 = new Trinket(game, "Trinket 7", Assets.TRINKET_7 , 0.1f, 7); 
        ITEMS_CACHE.add(TRINKET_7); 
        TRINKET_8 = new Trinket(game, "Trinket 8", Assets.TRINKET_8 , 0.1f, 8); 
        ITEMS_CACHE.add(TRINKET_8);
        TRINKET_9 = new Trinket(game, "Trinket 9", Assets.TRINKET_9 , 0.1f, 9); 
        ITEMS_CACHE.add(TRINKET_9);
        TRINKET_10 = new Trinket(game, "Trinket 10", Assets.TRINKET_10 , 0.1f, 10); 
        ITEMS_CACHE.add(TRINKET_10); 
        GLOVE_1 = new Gloves(game, "Gloves 1", Assets.GLOVE_1 , 0.1f, 1); 
        ITEMS_CACHE.add(GLOVE_1);
        GLOVE_2 = new Gloves(game, "Gloves 2", Assets.GLOVE_2 , 0.1f, 2); 
        ITEMS_CACHE.add(GLOVE_2); 
        GLOVE_3 = new Gloves(game, "Gloves 3", Assets.GLOVE_3 , 0.1f, 3); 
        ITEMS_CACHE.add(GLOVE_3); 
        GLOVE_4 = new Gloves(game, "Gloves 4", Assets.GLOVE_4 , 0.1f, 4); 
        ITEMS_CACHE.add(GLOVE_4);
       
    }
    
    protected final Game game;
    protected final String name;
    protected final BufferedImage image;
    protected final float proc;
    
    protected float hpMod;
    protected float maxHpMod;
    protected float atkMod;
    protected float armMod;
    protected float elemAtkMod;
    protected float elemArmMod;
    protected float movesMod;
    protected float critChanceMod;
    protected float blockChanceMod;
    protected float lifeStealMod;
    protected float arpenMod;

    public Item(Game game, String name, BufferedImage image, float proc) {
        super(ITEM_WIDTH, ITEM_HEIGHT);
        this.game = game;
        this.name = name;
        this.image = image;
        hpMod = 0;
        maxHpMod = 0;
        atkMod = 0;
        armMod = 0;
        elemAtkMod = 0;
        elemArmMod = 0;
        movesMod = 0;
        critChanceMod = 0;
        blockChanceMod = 0;
        lifeStealMod = 0;
        arpenMod = 0;
        this.proc = proc;
    }

    public Item(final Item item) {
        super(ITEM_WIDTH, ITEM_HEIGHT);
        game = item.game;
        name = item.name;
        image = item.image;
        hpMod = item.hpMod;
        maxHpMod = item.maxHpMod;
        atkMod = item.atkMod;
        armMod = item.armMod;
        elemAtkMod = item.elemAtkMod;
        elemArmMod = item.elemArmMod;
        movesMod = item.movesMod;
        critChanceMod = item.critChanceMod;
        blockChanceMod = item.blockChanceMod;
        lifeStealMod = item.lifeStealMod;
        arpenMod = item.arpenMod;
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
        if(this.equals(game.selectedObject)) {
            g.setColor(Color.green);
            g.drawRect((int)x, (int)y, width - 1, height - 1);
        }
    }

    @Override
    public void onClick(MouseEvent e) {
        game.selectedObject = this;
        game.getPanelManager().addObject(new TemporalPanel(new ItemPanel(this,(int)e.getX(),(int)e.getY(),180,120),1500));
    }

    @Override
    public boolean isCard() {
        return false;
    }

    @Override
    public boolean isPiece() {
        return false;
    }

    @Override
    public boolean isItem() {
        return true;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
    @Override
    public float modifyMaxHealth() {
        return maxHpMod;
    }
    
    @Override
    public float modifyHealth() {
        return hpMod;
    }

    @Override
    public float modifyDamage() {
        return atkMod;
    }

    @Override
    public float modifyArmor() {
        return armMod;
    }

    @Override
    public float modifyElementalDamage() {
        return elemAtkMod;
    }

    @Override
    public float modifyElementalArmor() {
        return elemArmMod;
    }

    @Override
    public float modifyMoves() {
        return movesMod;
    }

    @Override
    public float modifyCriticalChance() {
        return critChanceMod;
    }

    @Override
    public float modifyBlockChance() {
        return blockChanceMod;
    }

    @Override
    public float modifyLifeSteal() {
        return lifeStealMod;
    }

    @Override
    public float modifyArmorPenetration() {
        return arpenMod;
    }

    @Override
    public BufferedImage getIcon() {
        return image;
    }
    
    public static final class Food extends Item {
        public static final int MAX_MOVES = 3;
        public static final int MAX_ARMOR = 40;
        public static final int MAX_ELEM_ARMOR = 40;
        public static final int MAX_LEVEL = 28;
        
        
        public Food(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            super.movesMod = MAX_MOVES*level/MAX_LEVEL;
            super.armMod = MAX_MOVES*level/MAX_LEVEL;
            super.elemArmMod = MAX_MOVES*level/MAX_LEVEL;
        } 
    }
    public static final class Elixir extends Item {
        public static final int BIG_HP_VALUE = 300;
        public static final int BIG_ATK_VALUE = 50;
        public static final int BIG_DEF_VALUE = 10;
        public static final int BIG_MOVE_VALUE = 2;
        public static final int SMALL_HP_VALUE = 300;
        public static final int SMALL_ATK_VALUE = 25;
        public static final int SMALL_DEF_VALUE = 5;
        public static final int SMALL_MOVE_VALUE = 1;
        public Elixir(Game game, String name, BufferedImage image, float proc, String size, String color) {
            super(game, name, image, proc);
            if(size.equals("BIG")) {
                switch(color) {
                    case "RED" : {
                        super.maxHpMod = BIG_HP_VALUE;
                        break;
                    }
                    case "ORANGE" : {
                        super.atkMod = BIG_ATK_VALUE;
                        break;
                    }
                    case "YELLOW" : {
                        super.armMod = BIG_DEF_VALUE;
                        break;
                    }
                    case "BLUE" : {
                        super.elemAtkMod = BIG_ATK_VALUE;
                        break;
                    }
                    case "PURPLE" : {
                        super.elemArmMod = BIG_DEF_VALUE;
                        break;
                    }
                    case "GREEN" : {
                        super.movesMod = BIG_MOVE_VALUE;
                        break;
                    }
                    
                }
            } else if(size.equals("SMALL")) {
                switch(color) {
                    case "RED" : {
                        super.maxHpMod = SMALL_HP_VALUE;
                        break;
                    }
                    case "ORANGE" : {
                        super.atkMod = SMALL_ATK_VALUE;
                        break;
                    }
                    case "YELLOW" : {
                        super.armMod = SMALL_DEF_VALUE;
                        break;
                    }
                    case "BLUE" : {
                        super.elemAtkMod = SMALL_ATK_VALUE;
                        break;
                    }
                    case "PURPLE" : {
                        super.elemArmMod = SMALL_DEF_VALUE;
                        break;
                    }
                    case "GREEN" : {
                        super.movesMod = SMALL_MOVE_VALUE;
                        break;
                    }
                    
                }
            }
        }
        
    }
    public static class Weapon extends Item {
        
        public static final int MAX_DAMAGE = 400;
        public static final int MAX_PROC = 35;
        public static final int MIN_PROC = 5;
        
        public Weapon(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            critChanceMod = MIN_PROC;
            lifeStealMod = MIN_PROC;
            arpenMod = MIN_PROC;
        }
        
        public final static class Sword extends Weapon {
            
            public static final int NUMBER = 14;
            
            public Sword(Game game, String name, BufferedImage image, float proc, int level) {
                super(game, name, image, proc, level);
                this.atkMod = MAX_DAMAGE*level/NUMBER;
                this.critChanceMod = MAX_PROC*level/NUMBER;
            }
            
        }
        public final static class Spear extends Weapon {
            public static final int NUMBER = 14;
            public Spear(Game game, String name, BufferedImage image, float proc, int level) {
                super(game, name, image, proc, level);
                this.atkMod = MAX_DAMAGE*level/NUMBER;
                this.arpenMod = MAX_PROC*level/NUMBER;
            }
            
        }
        public final static class Mace extends Weapon {
            public static final int NUMBER = 14;
            public Mace(Game game, String name, BufferedImage image, float proc, int level) {
                super(game, name, image, proc, level);
                this.atkMod = MAX_DAMAGE*level/NUMBER;
                this.lifeStealMod = MAX_PROC*level/NUMBER;
            }
            
        }
        public final static class Axe extends Weapon {
            public static final int NUMBER = 10;
            public Axe(Game game, String name, BufferedImage image, float proc, int level) {
                super(game, name, image, proc, level);
                this.atkMod = MAX_DAMAGE*level/NUMBER;
                this.arpenMod = MAX_PROC*level/NUMBER;
                this.critChanceMod = MAX_PROC*level/NUMBER;
            }
            
        }
    }
    public static final class Shield extends Item {
        public static final int MAX_DEFFENSE = 80;
        public static final int NUMBER = 14;
        public static final int MAX_PROC = 50;
        public Shield(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            this.armMod = MAX_DEFFENSE*level/NUMBER;
            this.elemArmMod = MAX_DEFFENSE*level/NUMBER / 2;
            this.blockChanceMod = MAX_PROC*level/NUMBER;
        }
        
    }   
    public static final class Chest extends Item {
        public static final int MAX_DEFFENSE = 80;
        public static final int MAX_HP = 600;
        public static final int NUMBER = 5;
        public Chest(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            this.armMod = MAX_DEFFENSE*level/NUMBER;
            this.elemArmMod = MAX_DEFFENSE*level/NUMBER/ 2;
            this.maxHpMod = MAX_HP*level/NUMBER;
            this.hpMod = MAX_HP*level/NUMBER;
        }
        
    }
    public static final class Helm extends Item {
        public static final int MAX_DEFFENSE = 55;
        public static final int NUMBER = 5;
        public static final int MAX_HP = 400;
        public Helm(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            this.armMod = MAX_DEFFENSE*level/NUMBER;
            this.elemArmMod = MAX_DEFFENSE*level/NUMBER / 2;
            this.maxHpMod = MAX_HP*level/NUMBER;
            this.hpMod = MAX_HP*level/NUMBER;
        }
        
    }
    public static final class Gloves extends Item {
        public static final int MAX_DEFFENSE = 20;
        public static final int NUMBER = 4;
        public static final int MAX_HP = 200;
        public Gloves(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            this.armMod = MAX_DEFFENSE*level/NUMBER;
            this.elemArmMod = MAX_DEFFENSE*level/NUMBER / 2;
            this.maxHpMod = MAX_HP*level/NUMBER;
            this.hpMod = MAX_HP*level/NUMBER;
        }
        
    }
    public static final class Trinket extends Item {
        public static final int NUMBER = 10;
        public static final int MAX_PROC = 30;
        public static final int ELEM_DAMAGE = 500;
        public Trinket(Game game, String name, BufferedImage image, float proc, int level) {
            super(game, name, image, proc);
            this.critChanceMod = MAX_PROC*level/NUMBER;
            this.elemAtkMod = ELEM_DAMAGE*level/NUMBER;
        }       
    }
}
