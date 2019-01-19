/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import silmarillionreloaded.gfx.CropCode;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;

/**
 *
 * @author Ferran
 */
public class DirtGrass extends WorldElement{

    public DirtGrass(int width, int height) {
        super(width, height);
    }

    @Override
    protected void setImages() {
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                
                if(i == 0) {
                    if(j == 0) {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.NW);
                    }else if(j == height - 1) {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.SW);
                    } else {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.W);
                    }
                }else if(i == width - 1) {
                    if(j == 0) {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.NE);
                    }else if(j == height - 1) {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.SE);
                    } else {
                        images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.E);
                    }
                } else if(j == 0){
                    images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.N);
                } else if(j == height - 1) {
                    images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.S);
                } else {
                    images[i][j] = new TileImage(Texture.DIRT_GRASS, CropCode.CENTER_1);
                }
                
                
               
            }
        }
    }

   
    
}
