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

/**
 *
 * @author Ferran
 */
public class River extends WorldElement{

    public River(int width, int height) {
        super(width, height);
    }

    @Override
    protected void setImages() {
        Random random = new Random();
        for(int i = 0; i < width - 1; i++) {
            for(int j = 0; j < height - 1; j++) {
                if(i == 0) {
                    images[i][j] = new TileImage(Texture.GRASS_WATER, CropCode.N);
                    images[i][j+1] = new TileImage(Texture.GRASS_WATER, CropCode.S);
                } 
            }
        }
    }
    
}
