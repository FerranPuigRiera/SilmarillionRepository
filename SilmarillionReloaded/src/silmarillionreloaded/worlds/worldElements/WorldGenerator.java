/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import java.util.Random;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.gfx.CropCode;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class WorldGenerator {
    
    
    private final int width;
    private final int height;
    
    private final Tile[][] generatedWorld; 
    
    private final Texture baseTexture;
    
    public WorldGenerator(World world) {
        width = world.getWidth();
        height = world.getHeight();
        generatedWorld = new Tile[width][height];
        baseTexture = Texture.GRASS;
        init();
        setBase();
        setWorld();
        
    }
    
    public void init() {

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                generatedWorld[x][y] = new Tile(x,y);
            }
        }
        
    }
    
    public void setBase() {
        Random random = new Random();
        
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                
                switch(random.nextInt(4)) {
                    case 0: {
                        generatedWorld[i][j].addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_1));
                        break;
                    }
                    case 1: {
                        generatedWorld[i][j].addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_2));
                        break;
                    }
                    case 2: {
                        generatedWorld[i][j].addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_3));
                        break;
                    }
                    case 3: {
                        generatedWorld[i][j].addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_4));
                        break;
                    }
                    default: {
                        generatedWorld[i][j].addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_1));
                    }
                }
            }
        }
    }
    
    public void setWorld() {
        Random random = new Random();
        
        TallYellowBush bush = new TallYellowBush(2,3,1,5,2);
        //TallYellowBush bush2 = new TallYellowBush(7,5,1,3,4);
        
        //bush.fusionWith(bush2, 4, 6);
        
        addWorldElement(bush);
        
    }
    
    
    
    public void addWorldElement(final WorldElement we) {
        for(int j = 0; j < we.height; j++) {
            for(int i = 0; i < we.width; i++) {
                if(i + we.x < width && j + we.y < height && we.tiles[i][j] != null) {
                    generatedWorld[i+we.x][j+we.y].addImage(we.layer, we.tiles[i][j]);
                }
            }
        }
    }
    
    public Tile[][] getGeneratedWorld() {
        
        return generatedWorld;
    }
    
}
