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

    
    public static BufferedImage PIECE_0000, PIECE_0001, PIECE_0002, PIECE_0003, PIECE_0004, PIECE_0005, PIECE_0006, PIECE_0007, PIECE_0008, PIECE_0009, PIECE_0010,
                                            PIECE_0011, PIECE_0012, PIECE_0013, PIECE_0014, PIECE_0015, PIECE_0016, PIECE_0017, PIECE_0018, PIECE_0019, PIECE_0020,
                                            PIECE_0021, PIECE_0022, PIECE_0023, PIECE_0024, PIECE_0025, PIECE_0026, PIECE_0027, PIECE_0028, PIECE_0029, PIECE_0030,
                                            PIECE_0031, PIECE_0032, PIECE_0033, PIECE_0034, PIECE_0035, PIECE_0036, PIECE_0037, PIECE_0038, PIECE_0039, PIECE_0040,
                                            PIECE_0041, PIECE_0042, PIECE_0043, PIECE_0044, PIECE_0045, PIECE_0046, PIECE_0047;
    
    
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
        
        
        PIECE_0000 = ImageLoader.loadImage("/pieces/PIECE_0000.png");
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
        
        
    }
    
    
}
