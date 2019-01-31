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
import renderableObjects.RenderableObject;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.game.Game;
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
        super(TILE_WIDTH, TILE_HEIGHT);
        this.coordinate = coordinate;
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
    public void render(Graphics g, float x, float y){
        images.entrySet().forEach((entry) -> {
            g.drawImage(entry.getValue().getImage(), (int)(Game.INSTANCE.getGameCamera().getxOffset() + x), (int)(Game.INSTANCE.getGameCamera().getyOffset() + y), width, height, null);
        });
        if(isTileOccupied())piece.render(g, (int)(Game.INSTANCE.getGameCamera().getxOffset() + x), (int)(Game.INSTANCE.getGameCamera().getyOffset() + y));
    }

    /*
    Overrides renderableObject.onMouseMove because it needs to add the gameCameraOffset
    */
    @Override
    public void onMouseMove(MouseEvent e, int x, int y) {
        Rectangle bounds = new Rectangle(x + (int)Game.INSTANCE.getGameCamera().getxOffset(), y + (int)Game.INSTANCE.getGameCamera().getyOffset(), width, height);
        hovering = bounds.contains(e.getX(), e.getY());
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
        if(piece != null) {
            piece.tick();
        }
    }

    @Override
    public void onClick(MouseEvent e) {
        if(isTileOccupied()) {
            piece.onClick(e);
        } else {
            System.out.println("Click on tile");
        }
        
    }
    
    
}
