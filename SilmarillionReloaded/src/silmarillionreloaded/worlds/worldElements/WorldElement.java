/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import java.util.Random;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;

/**
 *
 * @author Ferran
 */
public abstract class WorldElement {
    
    
    
    protected final int width;
    protected final int height;
    protected TileImage[][] images;
    
    public WorldElement(int width, int height) {
        this.width = width;
        this.height = height;
        images = new TileImage[width][height];
        setImages();
        
    }

    protected abstract void setImages();
    public WorldElement fusionWith(WorldElement otherElement, int x_offset, int y_offset) {
        if(this.getClass().equals(otherElement.getClass())) {
            
            int fusionWidth = Math.max(width, otherElement.width + x_offset);
            int fusionHeight = Math.max(height, otherElement.height + y_offset);
            TileImage [][] fusion = new TileImage[fusionWidth][fusionHeight];
            
            for(int j = 0; j < fusionHeight; j++) {
                for(int i = 0; i < fusionWidth; i++) {
                    if(i < width && j < height) {
                        if(!images[i][j].getTexture().equals(Texture.NULL)) {
                            fusion[i][j] = images[i][j];
                        }
                    } else if(i - x_offset >= 0 && j - y_offset >= 0) {
                        if(!otherElement.images[i-x_offset][j-y_offset].getTexture().equals(Texture.NULL)) {
                            fusion[i][j] = otherElement.images[i-x_offset][j-y_offset];
                        }
                    } else {
                        fusion[i][j] = images[i][j];
                    } 
                }
            }
            
        }
        return this;
    }
    
    
}
