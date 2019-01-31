/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public interface Target {
    
    public boolean isPlayer();
    public boolean isPiece();
    public boolean isTile();
    public Player getPlayer();
    public Piece getPiece();
    public Tile getTile();
    
    
}
