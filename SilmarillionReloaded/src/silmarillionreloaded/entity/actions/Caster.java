/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity.actions;

import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Player;

/**
 *
 * @author Ferran
 */
public interface Caster {
    public boolean isPlayer();
    public boolean isPiece();
    public Player getPlayer();
    public Piece getPiece();
}
