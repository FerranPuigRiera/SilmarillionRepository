/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Graphics;
import java.util.List;
import java.util.Random;
import silmarillionreloaded.ObjectManager;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.tiles.Tile;

import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public class World extends ObjectManager<Tile>{
    
    public static final int NUMBER_COLUMNS = 55;
    public static final int NUMBER_ROWS = 30;
    
    
    private final Game game;
    private final int columns, rows;

    public World(Game game) {
        super(0,0,NUMBER_COLUMNS*Tile.TILE_WIDTH,NUMBER_ROWS*Tile.TILE_HEIGHT, NUMBER_COLUMNS*NUMBER_ROWS);
        this.game = game;
        Random random = new Random();
        
        columns = NUMBER_COLUMNS;
        rows = NUMBER_ROWS;
        WorldGenerator generator = new WorldGenerator(this);
        generator.getGeneratedWorld().forEach(tile -> addObject(tile));
        get(304).setPiece(Piece.PIECES_CACHE.get(0));
    }
    
    public int getColumns() {
        return columns;
    }
    
    public int getRows() {
        return rows;
    }
    
    public static int GetCoordinate(int x, int y) {
        return y*NUMBER_COLUMNS + x;
    }
    
    
    public Tile[][] getTilesAround(Tile[][] board, int x, int y) {
        Tile[][] tilesAround = new Tile[3][3];
        
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(x + i > 0 && x + i < columns && y + j > 0 && y + j < rows && !(i == 0 && j == 0)) {
                    tilesAround[i+1][j+1] = board[x+i][y+j];  
                } else {
                    tilesAround[i+1][j+1] = null;
                }   
            }
        }
        return tilesAround;
    } 
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void onClick() {
    }
}
