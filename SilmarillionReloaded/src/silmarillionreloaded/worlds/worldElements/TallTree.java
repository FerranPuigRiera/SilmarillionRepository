/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;

/**
 *
 * @author Ferran
 */
public class TallTree extends WorldElement{

    public TallTree(int x, int y, int layer) {
        super(Texture.TALL_TREE,x,y, layer, 2, 5);
    }

    @Override
    protected void setImages() {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 5; j++) {
                tiles[i][j] = TileImage.CreateTileImage(mainTexture, i,j);
            }
        }
    }
    
}
