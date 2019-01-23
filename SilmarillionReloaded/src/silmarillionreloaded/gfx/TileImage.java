/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import silmarillionreloaded.tiles.Texture;

/**
 *
 * @author Ferran
 */
public class TileImage {
    
    private static List<TileImage> TILE_IMAGE_CACHE = new ArrayList<>();
    
    
    private final Texture texture;
    private final int row;
    private final int column;
    
    private TileImage(Texture texture, CropCode cropCode) {
        if(texture == null) {
            throw new RuntimeException("Texture is null");
        }
        this.texture = texture;
        column = cropCode.getXonSpriteSheet();
        row = cropCode.getYonSpriteSheet();
    }
    
    
    private TileImage(Texture texture, int x, int y) {
        if(texture == null) {
            throw new RuntimeException("Texture is null");
        }
        this.texture = texture;
        row = y;
        column = x;
    }
    
    public static TileImage CreateTileImage(Texture texture, CropCode cropCode) {
        TileImage image = new TileImage(texture,cropCode);
        if(!TILE_IMAGE_CACHE.contains(image)) {
            TILE_IMAGE_CACHE.add(image);
        } 
        return TILE_IMAGE_CACHE.get(TILE_IMAGE_CACHE.indexOf(image));
    }
    public static TileImage CreateTileImage(Texture texture, int x, int y) {
        TileImage image = new TileImage(texture,x,y);
        if(!TILE_IMAGE_CACHE.contains(image)) {
            TILE_IMAGE_CACHE.add(image);
        } 
        return TILE_IMAGE_CACHE.get(TILE_IMAGE_CACHE.indexOf(image));
    }
    
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    
    public Texture getTexture() {
        return texture;
    }
    public BufferedImage getImage() {
        return texture.getSpriteSheet().getSubImage(column, row);
    }
    
    
}
