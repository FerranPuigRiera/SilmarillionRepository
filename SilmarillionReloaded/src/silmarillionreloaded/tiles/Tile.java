/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import silmarillionreloaded.RenderableObject;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class Tile extends RenderableObject implements Target{
    
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    
    private final int coordinate;
    private final Map<Integer, TileImage> images;
    
    private Item item;
    private Piece piece;

    public Tile(int coordinate) {
        super((coordinate % World.NUMBER_COLUMNS)*TILE_WIDTH,(coordinate / World.NUMBER_COLUMNS)*TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
        this.coordinate = coordinate;
        width = TILE_WIDTH;
        height = TILE_HEIGHT;
        images = new HashMap<>();
    }

    public int getCoordinate() {
        return coordinate;
    }
    
    public int getCoordinate_x() {
        return coordinate % World.NUMBER_COLUMNS;
    }

    public int getCoordinate_y() {
        return coordinate / World.NUMBER_COLUMNS;
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
    
    @Override
    public void render(Graphics g){
        images.entrySet().forEach((entry) -> {
            g.drawImage(entry.getValue().getImage(), getCoordinate_x()*width, getCoordinate_y()*height, width, height, null);
        });
        if(isTileOccupied())piece.render(g);
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

    @Override
    public void tick() {
        //bounds.setBounds(x, y, width, height);
        if(piece != null) {
            piece.tick();
        }
    }

    @Override
    public void onClick() {
        //
    }
    
    
}
