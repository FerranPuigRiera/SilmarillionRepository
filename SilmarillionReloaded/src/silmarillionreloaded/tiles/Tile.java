/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.awt.Graphics;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.player.Player;

/**
 *
 * @author Ferran
 */
public abstract class Tile implements Target{
    
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    
    protected final int coordinate_x, coordinate_y;
    protected final int width, height;
    
    public Tile(int coord_x, int coord_y) {
        coordinate_x = coord_x;
        coordinate_y = coord_y;
        width = TILE_WIDTH;
        height = TILE_HEIGHT;
    }
    
    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public boolean isPiece() {
        return false;
    }

    @Override
    public boolean isTile() {
        return true;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public Tile getTile() {
        return this;
    }
   
    
    public abstract void tick();
    
    public abstract void render(Graphics g, int x, int y);
    public abstract boolean isTerrainTile();
    public abstract boolean isPieceTile();
    
    
    public static class EmptyTile  extends Tile {

        public EmptyTile(int coord_x, int coord_y) {
            super(coord_x, coord_y);
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g, int x, int y) {
        }

        @Override
        public boolean isTerrainTile() {
            return false;
        }

        @Override
        public boolean isPieceTile() {
            return false;
        }

        

        
    }
    
    public static class TerrainTile extends Tile {
        
        TileImage tileImage;
        
        public TerrainTile(int coord_x, int coord_y, TileImage tileImage) {
            super(coord_x, coord_y);
            this.tileImage = tileImage;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g, int x, int y) {
            g.drawImage(tileImage.getImage(), x, y, width, height, null);
        }

        @Override
        public boolean isTerrainTile() {
            return true;
        }

        @Override
        public boolean isPieceTile() {
            return false;
        }
        
    }
    
    public static class PieceTile extends Tile {

        private final Piece piece;
        
        public PieceTile(final Piece piece, int coord_x, int coord_y) {
            super(coord_x, coord_y);
            this.piece = piece;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g, int x, int y) {
        }

        @Override
        public boolean isTerrainTile() {
            return false;
        }

        @Override
        public boolean isPieceTile() {
            return true;
        }
        
    }
    
}
