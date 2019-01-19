/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import java.util.Random;
import silmarillionreloaded.gfx.CropCode;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.tiles.Tile.ActiveTile;
import silmarillionreloaded.tiles.Tile.EmptyTile;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class WorldGenerator {
    
    
    private final int width;
    private final int height;
    private final int layers;
    
    private final Tile[][][] generatedWorld; 
    
    private final Texture baseTexture;
    
    public WorldGenerator(World world) {
        width = world.getWidth();
        height = world.getHeight();
        layers = world.getLayers();
        generatedWorld = new Tile[width][height][layers];
        baseTexture = Texture.GRASS;
        init();
        setBase();
        setWorld();
        
    }
    
    public void init() {
        for(int z = 0; z < layers; z++) {
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    generatedWorld[x][y][z] = new EmptyTile();
                }
            }
        }
    }
    
    public void setBase() {
        Random random = new Random();
        
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                switch(random.nextInt(4)) {
                    case 0: {
                        generatedWorld[i][j][0] = new ActiveTile(new TileImage(baseTexture, CropCode.CENTER_1));
                        break;
                    }
                    case 1: {
                        generatedWorld[i][j][0] = new ActiveTile(new TileImage(baseTexture, CropCode.CENTER_2));
                        break;
                    }
                    case 2: {
                        generatedWorld[i][j][0] = new ActiveTile(new TileImage(baseTexture, CropCode.CENTER_3));
                        break;
                    }
                    case 3: {
                        generatedWorld[i][j][0] = new ActiveTile(new TileImage(baseTexture, CropCode.CENTER_4));
                        break;
                    }
                    default: {
                        generatedWorld[i][j][0] = new ActiveTile(new TileImage(baseTexture, CropCode.CENTER_1));
                    }
                }
            }
        }
    }
    
    public void setWorld() {
        Random random = new Random();
        
        TallYellowBush bush = new TallYellowBush(4,4);
        TallYellowBush bush2 = new TallYellowBush(5,2);
        
        bush.fusionWith(bush2, 2, 2);
        
        addWorldElement(bush, 7,5,1);
        
    }
    
    
    
    public void addWorldElement(final WorldElement we, int x, int y, int layer) {
        for(int j = 0; j < we.height; j++) {
            for(int i = 0; i < we.width; i++) {
                if(i + x < width && j + y < height) {
                    generatedWorld[i+x][j+y][layer] = new ActiveTile(we.images[i][j]);
                }
            }
        }
    }
    
    public Tile[][][] getGeneratedWorld() {
        
        return generatedWorld.clone();
    }
    
}
