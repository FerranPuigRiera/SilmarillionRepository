/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Graphics;
import java.util.Random;
import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.tiles.Tile;

import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public class World {
    
    private static final int NUMBER_COLUMNS = 55;
    private static final int NUMBER_ROWS = 30;
    
    
    private final Game game;
    private final int width, height;
    private final Tile[][] world;
    
    

    public World(Game game) {
        this.game = game;
        Random random = new Random();
        
        width = NUMBER_COLUMNS;
        height = NUMBER_ROWS;
        WorldGenerator generator = new WorldGenerator(this);
        world = generator.getGeneratedWorld();
    }
    

    
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    
    public void tick() {
        
    }
    
    public void render(Graphics g) {
        
        int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + Application.FRAME_WIDTH) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + Application.FRAME_HEIGHT) / Tile.TILE_HEIGHT + 1);
        
        
        for(int y = yStart; y < yEnd; y++) {
            for(int x = xStart; x < xEnd; x++) {   
                world[x][y].render(g);
            }
        }
    }
    
    public Tile[][] getTilesAround(Tile[][] board, int x, int y) {
        Tile[][] tilesAround = new Tile[3][3];
        
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(x + i > 0 && x + i < width && y + j > 0 && y + j < height && !(i == 0 && j == 0)) {
                    tilesAround[i+1][j+1] = board[x+i][y+j];  
                } else {
                    tilesAround[i+1][j+1] = null;
                }   
            }
        }
        return tilesAround;
    } 
}
