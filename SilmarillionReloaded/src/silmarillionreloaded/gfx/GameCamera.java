/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import silmarillionreloaded.renderableObjects.TemporalPanel;
import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class GameCamera {
    
    private final Game game;
    private float xOffset, yOffset;
    
    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnPiece(Piece e) {
        
        
        Tile tile = game.getWorld().findTilesPieceOnWorld(e);
        
        if(e == null) {
            System.err.println("Piece not found!");
            TemporalPanel.addErrorMessage("ERROR: Piece not found");
            return;
        }
        
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
