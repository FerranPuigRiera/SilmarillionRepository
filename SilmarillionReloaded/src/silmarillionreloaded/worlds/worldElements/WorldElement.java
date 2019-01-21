/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds.worldElements;

import silmarillionreloaded.gfx.CropCode;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.tiles.Tile.TerrainTile;
import silmarillionreloaded.tiles.Tile.EmptyTile;

/**
 *
 * @author Ferran
 */
public abstract class WorldElement {
    
    
    protected Texture mainTexture;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int layer;
    protected Tile[][][] tiles;
    
    public WorldElement(Texture mainTexture, int x, int y, int layer, int width, int height) {
        this.mainTexture = mainTexture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height][layer];
        setImages();
        
    }

    protected abstract void setImages();
    public void fusionWith(WorldElement otherElement, int x_offset, int y_offset) {
        if(this.getClass().equals(otherElement.getClass())) {
            int fusionWidth = Math.max(width, otherElement.width + x_offset);
            int fusionHeight = Math.max(height, otherElement.height + y_offset);
            Tile [][] fusion = new Tile[fusionWidth][fusionHeight];
            
            for(int j = 0; j < fusionHeight; j++) {
                for(int i = 0; i < fusionWidth; i++) {
                    if(i < width && j < height) {
                        if(tiles[i][j].isTerrainTile()) {
                            fusion[i][j][layer] = tiles[i][j];
                            if(i - x_offset >= 0 && j - y_offset >= 0 && otherElement.tiles[i-x_offset][j-y_offset].isTerrainTile()) {
                                fusion[i][j] = new TerrainTile(i,j,TileImage.CreateTileTileImage(mainTexture, CropCode.CENTER_1));
                            }
                        }
                    } else if(i - x_offset >= 0 && j - y_offset >= 0) {
                        if(otherElement.tiles[i-x_offset][j-y_offset].isTerrainTile()) {
                            fusion[i][j] = otherElement.tiles[i-x_offset][j-y_offset];
                        }
                    } else {
                        fusion[i][j] = new EmptyTile(i,j);
                    } 
                }
            }
            width = fusionWidth;
            height = fusionHeight;
            tiles = fusion;
            
        }
    }
    
    
}
