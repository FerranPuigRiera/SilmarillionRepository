/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;

/**
 *
 * @author Ferran
 */
public class Tile implements Target {
    
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    
    private final int coordinate_x;
    private final int coordinate_y;
    private final int width;
    private final int height;
    private final Map<Integer, TileImage> images;
    
    private Item item;
    private Piece piece;
    
    
    public Tile(int coord_x, int coord_y) {
        coordinate_x = coord_x;
        coordinate_y = coord_y;
        width = TILE_WIDTH;
        height = TILE_HEIGHT;
        images = new HashMap<>();
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Integer,TileImage> getImages() {
        return images;
    }
    
    public void addImage(int layer, TileImage image) {
        images.put(layer, image);
    }
    
    public void setPiece(final Piece piece) {
        this.piece = piece;
    }
    
    public void removePiece() {
        piece = null;
    }

    public Item getItem() {
        return item;
    }
    
    public void setItem(final Item item) {
        this.item = item;
    }
    
    public void tick(){
    }
    public void render(Graphics g){
        images.entrySet().forEach((entry) -> {
            g.drawImage(entry.getValue().getImage(), coordinate_x*width, coordinate_y*height, width, height, null);
        });
        if(isTileOccupied())piece.render(g,coordinate_x*height,coordinate_y*width);
    }

    public boolean isTileOccupied() {
        return piece != null;
    }
    
    public boolean tileHasItem() {
        return item != null;
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
        return piece;
    }

    @Override
    public Tile getTile() {
        return this;
    }
    
    
}
