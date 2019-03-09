/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Set;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class DeployTiles {

    private final Set<Tile> tiles;
    
    public DeployTiles() {
        tiles = new HashSet();
    }
    
    public void addTile(Tile tile) {
        tiles.add(tile);
    }
    public void removeTile(Tile tile) {
        tiles.remove(tile);
    }
    public boolean contains(Tile tile) {
        return tiles.contains(tile);
    }
    
    public Set<Tile> getSet() {
        return ImmutableSet.copyOf(tiles);
    }
    
}
