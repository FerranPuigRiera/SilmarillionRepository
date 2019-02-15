/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.game.Game;
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
    
    private final List<Tile> generatedWorld; 
    
    private final Texture baseTexture;
    
    public WorldGenerator(Game game, int width,int height) {
        this.width = width;
        this.height = height;
        generatedWorld = new ArrayList<>();
        baseTexture = Texture.GRASS;
        init(game);
        setBase();
        setWorld();
        
    }
    
    public void init(final Game game) {

        for(int i = 0; i < width*height; i++) {
            generatedWorld.add(new Tile(game,i));
        }
    }
    
    public void setBase() {
        Random random = new Random();
        
        for(Tile tile : generatedWorld) {
            switch(random.nextInt(4)) {
                case 0: 
                    tile.addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_1));
                    break;
                case 1: 
                    tile.addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_2));
                    break;
                case 2: 
                    tile.addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_3));
                    break;
                case 3: 
                    tile.addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_4));
                    break;
                default: 
                    tile.addImage(0, TileImage.CreateTileImage(baseTexture, CropCode.CENTER_1));
                    break;
        
            }
        }
    }
    
    public void setWorld() {
        Random random = new Random();
        
        TallYellowBush bush = new TallYellowBush(2,3,1,5,2);
        GrassLake lake = new GrassLake(10,7,1,5,4);
        //TallYellowBush bush2 = new TallYellowBush(7,5,1,3,4);
        
        //bush.fusionWith(bush2, 4, 6);
        
        addWorldElement(bush);
        addWorldElement(lake);
    }
    
    
    
    public void addWorldElement(final WorldElement we) {
        for(int j = 0; j < we.height; j++) {
            for(int i = 0; i < we.width; i++) {
                if(i + we.x < width && j + we.y < height && we.tiles[i][j] != null) {
                    generatedWorld.get(World.GetCoordinate(i+we.x, j+we.y)).addImage(we.layer, we.tiles[i][j]);
                }
            }
        }
    }
    
    public List<Tile> getGeneratedWorld() {
        
        return generatedWorld;
    }
    
}
