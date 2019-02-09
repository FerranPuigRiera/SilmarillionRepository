/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class GameCamera {
    
    private float xOffset, yOffset;
    
    public GameCamera(float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnPiece(Piece e) {
        
        
        Tile tile = Game.INSTANCE.getWorld().findTilesPieceOnWorld(e);
        xOffset = -tile.getCoordinate_x()*Tile.TILE_WIDTH + Application.FRAME_WIDTH / 2 - e.getWidth() / 2;
        yOffset = -tile.getCoordinate_y()*Tile.TILE_HEIGHT + Application.FRAME_HEIGHT / 2 - e.getHeight() / 2;
        //xOffset = tile.getCoordinate_x()*Tile.TILE_WIDTH - Application.FRAME_WIDTH / 2 + e.getWidth() / 2;
        //yOffset = tile.getCoordinate_y()*Tile.TILE_HEIGHT - Application.FRAME_HEIGHT / 2 + e.getHeight() / 2; 
    }
    
    public void move(float xAmt, float yAmt) {
        xOffset -= xAmt;
        yOffset -= yAmt;
    }
    
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
