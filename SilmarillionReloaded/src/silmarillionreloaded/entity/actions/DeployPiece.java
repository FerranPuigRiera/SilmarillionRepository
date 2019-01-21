/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity.actions;

import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class DeployPiece implements PlayableAction {
    
    private final Piece piece;
    private final Tile deployTile;
    
    public DeployPiece(Piece piece, Tile deployTile) {
        this.piece = piece;
        this.deployTile = deployTile;
    }

    @Override
    public void execute(Game game) {
        if(!game.getWorld().deployPiece(deployTile, piece)) {
            throw new RuntimeException("Immpossible to deploy piece");
        }
    }

    @Override
    public boolean isExecutable(Game game) {
        return !game.getWorld().isTileOccupied(deployTile);
    }

}
