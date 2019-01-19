/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.awt.Graphics;
import silmarillionreloaded.gfx.TileImage;

/**
 *
 * @author Ferran
 */
public abstract class Tile {
    
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    
    
    protected final int width, height;
    
    public Tile() {
        width = TILE_WIDTH;
        height = TILE_HEIGHT;
    }
    
   
    
    public abstract void tick();
    
    public abstract void render(Graphics g, int x, int y);
    
    
    
    public static class EmptyTile  extends Tile {

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g, int x, int y) {
        }

        
    }
    
    public static class ActiveTile extends Tile {
        
        TileImage tileImage;
        
        public ActiveTile(TileImage tileImage) {
            this.tileImage = tileImage;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g, int x, int y) {
            g.drawImage(tileImage.getImage(), x, y, width, height, null);
        }
        
    }
    
}
