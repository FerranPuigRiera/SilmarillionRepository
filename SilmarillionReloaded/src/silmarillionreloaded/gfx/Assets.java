/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ferran
 */
public class Assets {
    
    public static SpriteSheet lightEarth, mediumEarth, grass, hole, lava, blackEarth,
            desert, water, darkEarth, darkGrass, waterGrass, tallGreenBush,
            tallYellowBush, shortGreenBush, dirtGrass, tallTree; 

    public static SpriteSheet BLESS, EARTH_1, EARTH_2, FIRE, HEAL, METEOR, NATURE, POLEN,
                              SHADOW, SLASH, SUMMON, THUNDER, WATER, AURA;
    
    
    public static BufferedImage PIECE_0001, PIECE_0002, PIECE_0003, PIECE_0004, PIECE_0005, PIECE_0006, PIECE_0007, PIECE_0008, PIECE_0009, PIECE_0010,
                                            PIECE_0011, PIECE_0012, PIECE_0013, PIECE_0014, PIECE_0015, PIECE_0016, PIECE_0017, PIECE_0018, PIECE_0019, PIECE_0020,
                                            PIECE_0021, PIECE_0022, PIECE_0023, PIECE_0024, PIECE_0025, PIECE_0026, PIECE_0027, PIECE_0028, PIECE_0029, PIECE_0030,
                                            PIECE_0031, PIECE_0032, PIECE_0033, PIECE_0034, PIECE_0035, PIECE_0036, PIECE_0037, PIECE_0038, PIECE_0039, PIECE_0040,
                                            PIECE_0041, PIECE_0042, PIECE_0043, PIECE_0044, PIECE_0045, PIECE_0046, PIECE_0047;
    
    public static BufferedImage CARD_0000, CARD_0001, CARD_0002, CARD_0003, CARD_0004, CARD_0005, CARD_0006, CARD_0007, CARD_0008, CARD_0009, CARD_0010,
                                           CARD_0011, CARD_0012, CARD_0013, CARD_0014, CARD_0015, CARD_0016, CARD_0017, CARD_0018, CARD_0019, CARD_0020,
                                           CARD_0021, CARD_0022, CARD_0023, CARD_0024, CARD_0025, CARD_0026, CARD_0027, CARD_0028, CARD_0029, CARD_0030,
                                           CARD_0031, CARD_0032, CARD_0033, CARD_0034, CARD_0035, CARD_0036, CARD_0037, CARD_0038, CARD_0039, CARD_0040,
                                           CARD_0041, CARD_0042;
    
    public static BufferedImage TREASURE, MAP, GREAT_AXE, AXE, HAMMER, GREAT_SHIELD, SHIELD, 
                                PERGAMIN, STAFF, BAG, GREAT_DOUBLE_AXE, DOUBLE_AXE, 
                                CHEST, BOW, WOODEN_SWORD, TOOLS, GREAT_SWORD, SWORD, 
                                HELM, HEART, CROSS, BOOK, COIN, GREEN_GEM, BLUE_GEM, 
                                RED_GEM, GREEN_POTION, BLUE_POTION, RED_POTION, MAIL;
    
    public static BufferedImage GAME_BACKGROUND_1;
    
    public static BufferedImage END_TURN_B, END_TURN_H, COLLECT_B, COLLECT_H;
    
    
    
    
    public static void init() {
        
        //SpriteSheet baseOutAtlas = new SpriteSheet(ImageLoader.loadImage("/terrain/base_out_atlas.png/"),32,32);
        SpriteSheet terrainAtlas = new SpriteSheet(ImageLoader.loadImage("/terrain/terrain_atlas.png"),32,32);
        lightEarth = terrainAtlas.createSubSpriteSheet(15, 0, 3, 6);
        mediumEarth = terrainAtlas.createSubSpriteSheet(18, 0, 3, 6);
        grass = terrainAtlas.createSubSpriteSheet(21, 0, 3, 6);
        hole = terrainAtlas.createSubSpriteSheet(24, 0, 3, 6);
        lava = terrainAtlas.createSubSpriteSheet(18, 6, 3, 6);
        blackEarth = terrainAtlas.createSubSpriteSheet(21, 6, 3, 6);
        desert = terrainAtlas.createSubSpriteSheet(0, 9, 3, 6);
        water = terrainAtlas.createSubSpriteSheet(9, 9, 3, 6);
        darkEarth = terrainAtlas.createSubSpriteSheet(3, 26, 3, 6);
        darkGrass = terrainAtlas.createSubSpriteSheet(3, 24, 3, 6);
        waterGrass = terrainAtlas.createSubSpriteSheet(6, 9, 3, 6);
        tallGreenBush = terrainAtlas.createSubSpriteSheet(0, 20, 3, 6);
        tallYellowBush = terrainAtlas.createSubSpriteSheet(0, 26, 3, 6);
        shortGreenBush = terrainAtlas.createSubSpriteSheet(3, 20, 3, 6);
        dirtGrass = terrainAtlas.createSubSpriteSheet(5, 15, 3, 6);
        
        tallTree = terrainAtlas.createSubSpriteSheet(30, 0, 2, 6);
        
        
        BLESS = new SpriteSheet(ImageLoader.loadImage("/animations/bless.png"), 5,6);
        EARTH_1 = new SpriteSheet(ImageLoader.loadImage("/animations/earth.png"), 9,6);
        EARTH_2 = new SpriteSheet(ImageLoader.loadImage("/animations/earth2.png"), 5,4);
        FIRE = new SpriteSheet(ImageLoader.loadImage("/animations/fire.png"), 5,5);
        HEAL = new SpriteSheet(ImageLoader.loadImage("/animations/heal.png"), 5,5);
        METEOR = new SpriteSheet(ImageLoader.loadImage("/animations/meteor.png"), 5,5);
        NATURE = new SpriteSheet(ImageLoader.loadImage("/animations/nature.png"), 5,6);
        POLEN = new SpriteSheet(ImageLoader.loadImage("/animations/polen.png"), 5,3);
        SHADOW = new SpriteSheet(ImageLoader.loadImage("/animations/shadow2.png"), 5,4);
        SLASH = new SpriteSheet(ImageLoader.loadImage("/animations/slash.png"), 5,4);
        SUMMON = new SpriteSheet(ImageLoader.loadImage("/animations/summon.png"), 5,3);
        THUNDER = new SpriteSheet(ImageLoader.loadImage("/animations/thunder.png"), 5,3);
        AURA = new SpriteSheet(ImageLoader.loadImage("/animations/aura.png"),5,4);
        
        PIECE_0001 = ImageLoader.loadImage("/pieces/PIECE_0001.png");
        PIECE_0002 = ImageLoader.loadImage("/pieces/PIECE_0002.png");
        PIECE_0003 = ImageLoader.loadImage("/pieces/PIECE_0003.png");
        PIECE_0004 = ImageLoader.loadImage("/pieces/PIECE_0004.png");
        PIECE_0005 = ImageLoader.loadImage("/pieces/PIECE_0005.png");
        PIECE_0006 = ImageLoader.loadImage("/pieces/PIECE_0006.png");
        PIECE_0007 = ImageLoader.loadImage("/pieces/PIECE_0007.png");
        PIECE_0008 = ImageLoader.loadImage("/pieces/PIECE_0008.png");
        PIECE_0009 = ImageLoader.loadImage("/pieces/PIECE_0009.png");
        PIECE_0010 = ImageLoader.loadImage("/pieces/PIECE_0010.png");
        PIECE_0011 = ImageLoader.loadImage("/pieces/PIECE_0011.png");
        PIECE_0012 = ImageLoader.loadImage("/pieces/PIECE_0012.png");
        PIECE_0013 = ImageLoader.loadImage("/pieces/PIECE_0013.png");
        PIECE_0014 = ImageLoader.loadImage("/pieces/PIECE_0014.png");
        PIECE_0015 = ImageLoader.loadImage("/pieces/PIECE_0015.png");
        PIECE_0016 = ImageLoader.loadImage("/pieces/PIECE_0016.png");
        PIECE_0017 = ImageLoader.loadImage("/pieces/PIECE_0017.png");
        PIECE_0018 = ImageLoader.loadImage("/pieces/PIECE_0018.png");
        PIECE_0019 = ImageLoader.loadImage("/pieces/PIECE_0019.png");
        PIECE_0020 = ImageLoader.loadImage("/pieces/PIECE_0020.png");
        PIECE_0021 = ImageLoader.loadImage("/pieces/PIECE_0021.png");
        PIECE_0022 = ImageLoader.loadImage("/pieces/PIECE_0022.png");
        PIECE_0023 = ImageLoader.loadImage("/pieces/PIECE_0023.png");
        PIECE_0024 = ImageLoader.loadImage("/pieces/PIECE_0024.png");
        PIECE_0025 = ImageLoader.loadImage("/pieces/PIECE_0025.png");
        PIECE_0026 = ImageLoader.loadImage("/pieces/PIECE_0026.png");
        PIECE_0027 = ImageLoader.loadImage("/pieces/PIECE_0027.png");
        PIECE_0028 = ImageLoader.loadImage("/pieces/PIECE_0028.png");
        PIECE_0029 = ImageLoader.loadImage("/pieces/PIECE_0029.png");
        PIECE_0030 = ImageLoader.loadImage("/pieces/PIECE_0030.png");
        PIECE_0031 = ImageLoader.loadImage("/pieces/PIECE_0031.png");
        PIECE_0032 = ImageLoader.loadImage("/pieces/PIECE_0032.png");
        PIECE_0033 = ImageLoader.loadImage("/pieces/PIECE_0033.png");
        PIECE_0034 = ImageLoader.loadImage("/pieces/PIECE_0034.png");
        PIECE_0035 = ImageLoader.loadImage("/pieces/PIECE_0035.png");
        PIECE_0036 = ImageLoader.loadImage("/pieces/PIECE_0036.png");
        PIECE_0037 = ImageLoader.loadImage("/pieces/PIECE_0037.png");
        PIECE_0038 = ImageLoader.loadImage("/pieces/PIECE_0038.png");
        PIECE_0039 = ImageLoader.loadImage("/pieces/PIECE_0039.png");
        PIECE_0040 = ImageLoader.loadImage("/pieces/PIECE_0040.png");
        PIECE_0041 = ImageLoader.loadImage("/pieces/PIECE_0041.png");
        PIECE_0042 = ImageLoader.loadImage("/pieces/PIECE_0042.png");
        PIECE_0043 = ImageLoader.loadImage("/pieces/PIECE_0043.png");
        PIECE_0044 = ImageLoader.loadImage("/pieces/PIECE_0044.png");
        PIECE_0045 = ImageLoader.loadImage("/pieces/PIECE_0045.png");
        PIECE_0046 = ImageLoader.loadImage("/pieces/PIECE_0046.png");
        PIECE_0047 = ImageLoader.loadImage("/pieces/PIECE_0047.png");
        
        CARD_0000 = ImageLoader.loadImage("/cards/CARD_0000.gif");
        CARD_0001 = ImageLoader.loadImage("/cards/CARD_0001.gif");
        CARD_0002 = ImageLoader.loadImage("/cards/CARD_0002.gif");
        CARD_0003 = ImageLoader.loadImage("/cards/CARD_0003.gif");
        CARD_0004 = ImageLoader.loadImage("/cards/CARD_0004.gif");
        CARD_0005 = ImageLoader.loadImage("/cards/CARD_0005.gif");
        CARD_0006 = ImageLoader.loadImage("/cards/CARD_0006.gif");
        CARD_0007 = ImageLoader.loadImage("/cards/CARD_0007.gif");
        CARD_0008 = ImageLoader.loadImage("/cards/CARD_0008.gif");
        CARD_0009 = ImageLoader.loadImage("/cards/CARD_0009.gif");
        CARD_0010 = ImageLoader.loadImage("/cards/CARD_0010.gif");
        
        CARD_0011 = ImageLoader.loadImage("/cards/CARD_0011.gif");
        CARD_0012 = ImageLoader.loadImage("/cards/CARD_0012.gif");
        CARD_0013 = ImageLoader.loadImage("/cards/CARD_0013.gif");
        CARD_0014 = ImageLoader.loadImage("/cards/CARD_0014.gif");
        CARD_0015 = ImageLoader.loadImage("/cards/CARD_0015.gif");
        CARD_0016 = ImageLoader.loadImage("/cards/CARD_0016.gif");
        CARD_0017 = ImageLoader.loadImage("/cards/CARD_0017.gif");
        CARD_0018 = ImageLoader.loadImage("/cards/CARD_0018.gif");
        CARD_0019 = ImageLoader.loadImage("/cards/CARD_0019.gif");
        CARD_0020 = ImageLoader.loadImage("/cards/CARD_0020.gif");
        
        CARD_0021 = ImageLoader.loadImage("/cards/CARD_0021.gif");
        CARD_0022 = ImageLoader.loadImage("/cards/CARD_0022.gif");
        CARD_0023 = ImageLoader.loadImage("/cards/CARD_0023.gif");
        CARD_0024 = ImageLoader.loadImage("/cards/CARD_0024.gif");
        CARD_0025 = ImageLoader.loadImage("/cards/CARD_0025.gif");
        CARD_0026 = ImageLoader.loadImage("/cards/CARD_0026.gif");
        CARD_0027 = ImageLoader.loadImage("/cards/CARD_0027.gif");
        CARD_0028 = ImageLoader.loadImage("/cards/CARD_0028.gif");
        CARD_0029 = ImageLoader.loadImage("/cards/CARD_0029.gif");
        CARD_0030 = ImageLoader.loadImage("/cards/CARD_0030.gif");
        
        CARD_0031 = ImageLoader.loadImage("/cards/CARD_0031.gif");
        CARD_0032 = ImageLoader.loadImage("/cards/CARD_0032.gif");
        CARD_0033 = ImageLoader.loadImage("/cards/CARD_0033.gif");
        CARD_0034 = ImageLoader.loadImage("/cards/CARD_0034.gif");
        CARD_0035 = ImageLoader.loadImage("/cards/CARD_0035.gif");
        CARD_0036 = ImageLoader.loadImage("/cards/CARD_0036.gif");
        CARD_0037 = ImageLoader.loadImage("/cards/CARD_0037.gif");
        CARD_0038 = ImageLoader.loadImage("/cards/CARD_0038.gif");
        CARD_0039 = ImageLoader.loadImage("/cards/CARD_0039.gif");
        CARD_0040 = ImageLoader.loadImage("/cards/CARD_0040.gif");
        
        CARD_0041 = ImageLoader.loadImage("/cards/CARD_0041.gif");
        CARD_0042 = ImageLoader.loadImage("/cards/CARD_0042.gif");
        
        
        TREASURE = ImageLoader.loadImage("/items/chest.png");
        
        SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/items/items.png"),6,5);
        
        MAP = items.getSubImage(0, 0);
        GREAT_AXE = items.getSubImage(1, 0);
        AXE = items.getSubImage(2, 0);
        HAMMER = items.getSubImage(3, 0);
        GREAT_SHIELD = items.getSubImage(0, 0);
        SHIELD = items.getSubImage(4, 0);
        PERGAMIN = items.getSubImage(5, 0);
        STAFF = items.getSubImage(0, 1);
        BAG = items.getSubImage(1, 1);
        GREAT_DOUBLE_AXE = items.getSubImage(2, 1);
        DOUBLE_AXE = items.getSubImage(3, 1);
        CHEST = items.getSubImage(4, 1);
        BOW = items.getSubImage(5, 1);
        WOODEN_SWORD = items.getSubImage(0, 2);
        TOOLS = items.getSubImage(1, 2);
        GREAT_SWORD = items.getSubImage(2, 2);
        SWORD = items.getSubImage(3, 2);
        HELM = items.getSubImage(4, 2);
        HEART = items.getSubImage(5, 2);
        CROSS = items.getSubImage(0, 3);
        BOOK = items.getSubImage(1, 3);
        COIN = items.getSubImage(2, 3);
        GREEN_GEM = items.getSubImage(3, 3);
        BLUE_GEM = items.getSubImage(4, 3);
        RED_GEM = items.getSubImage(5, 3);
        GREEN_POTION = items.getSubImage(0, 4);
        BLUE_POTION = items.getSubImage(2, 4);
        RED_POTION = items.getSubImage(3, 4);
        MAIL = items.getSubImage(4, 4);
        
        
        END_TURN_B = ImageLoader.loadImage("/buttons/EndTurnB.png");
        COLLECT_B = ImageLoader.loadImage("/buttons/CollectB.png");
        END_TURN_H = ImageLoader.loadImage("/buttons/EndTurnH.png");
        COLLECT_H = ImageLoader.loadImage("/buttons/CollectH.png");
        
        GAME_BACKGROUND_1 = ImageLoader.loadImage("/backgrounds/GameBackground1.jpg");
        
    }
    
    
}
