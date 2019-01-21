/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import silmarillionreloaded.Application;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.tiles.Tile.TerrainTile;
import silmarillionreloaded.tiles.Tile.EmptyTile;
import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public class World {
    
    private static final int NUMBER_COLUMNS = 55;
    private static final int NUMBER_ROWS = 30;
    private static final int NUMBER_LAYERS = 3;
    
    
    private final Game game;
    private int width, height, layers;
    private Tile[][][] terrain;
    private Tile[][] board;
    private final Map<Tile,Piece> piecesOnBoard;
    
    

    public World(Game game) {
        this.game = game;
        piecesOnBoard = new HashMap<>();
        loadWorld();
    }
    
    private void loadWorld(){
        
        Random random = new Random();
        
        width = NUMBER_COLUMNS;
        height = NUMBER_ROWS;
        layers = NUMBER_LAYERS;
        WorldGenerator generator = new WorldGenerator(this);
        terrain = generator.getGeneratedWorld();
        board = new Tile[width][height];
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                board[i][j] = new EmptyTile(i,j);
            }
        }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getLayers() {
        return layers;
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
                for(int z = 0; z < layers; z++) {
                    
                    terrain[x][y][z].render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
                }
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

    
    public boolean isTileOccupied(Tile tile) {
        return piecesOnBoard.containsKey(tile);
    }
    
    public boolean deployPiece(Tile tile, Piece piece) {
        if(!piecesOnBoard.containsKey(tile)) {
            piecesOnBoard.put(tile, piece);
            return true;
        }
        return false;
    }
    public boolean removePiece(Tile tile) {
        if(!piecesOnBoard.containsKey(tile)) {
            piecesOnBoard.remove(tile);
            return true;
        }
        return false;
        
    }
    public boolean movePiece(Tile sourceTile, Tile destTile) {
        if(piecesOnBoard.containsKey(sourceTile)) {
            Piece piece = piecesOnBoard.get(sourceTile);
            piecesOnBoard.remove(sourceTile);
            if(!piecesOnBoard.containsKey(destTile)) {
                piecesOnBoard.put(destTile, piece);
                return true;
            }
        }
        return false;
    }
    
}
