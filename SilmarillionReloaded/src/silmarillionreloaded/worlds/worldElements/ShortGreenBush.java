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
public class ShortGreenBush extends WorldElement{

    public ShortGreenBush(int x, int y,int layer,int width, int height) {
        super(Texture.SHORT_GREEN_BUSH,x,y, layer, width, height);
    }

    @Override
    protected void setImages() {
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                
                if(i == 0) {
                    if(j == 0) {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.NW);
                    }else if(j == height - 1) {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.SW);
                    } else {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.W);
                    }
                }else if(i == width - 1) {
                    if(j == 0) {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.NE);
                    }else if(j == height - 1) {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.SE);
                    } else {
                        tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.E);
                    }
                } else if(j == 0){
                    tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.N);
                } else if(j == height - 1) {
                    tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.S);
                } else {
                    tiles[i][j] = TileImage.CreateTileImage(mainTexture, CropCode.CENTER_1);
                }
                
                
               
            }
        }
    }
    
}
