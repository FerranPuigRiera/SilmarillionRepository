/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Graphics;
import java.util.Random;
import silmarillionreloaded.Application;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.tiles.Texture;
import silmarillionreloaded.tiles.Tile;
import silmarillionreloaded.tiles.Tile.ActiveTile;
import silmarillionreloaded.tiles.Tile.EmptyTile;
import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public class World {
    
    private static final int NUMBER_COLUMNS = 20;
    private static final int NUMBER_ROWS = 20;
    private static final int NUMBER_LAYERS = 3;
    
    
    private final Application app;
    private int width, height, layers;
    private Tile[][][] board;

    public World(Application app, String path) {
        this.app = app;
        loadWorld(path);
    }
    
    private void loadWorld(String path){
        
        Random random = new Random();
        
        width = NUMBER_COLUMNS;
        height = NUMBER_ROWS;
        layers = NUMBER_LAYERS;
        WorldGenerator generator = new WorldGenerator(this);
        board = generator.getGeneratedWorld();
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
        
        int xStart = (int) Math.max(0, app.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (app.getGameCamera().getxOffset() + Application.FRAME_WIDTH) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, app.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (app.getGameCamera().getyOffset() + Application.FRAME_HEIGHT) / Tile.TILE_HEIGHT + 1);
        
        for(int y = yStart; y < yEnd; y++) {
            for(int x = xStart; x < xEnd; x++) {
                for(int z = 0; z < layers; z++) {
                    
                    board[x][y][z].render(g, (int) (x * Tile.TILE_WIDTH - app.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - app.getGameCamera().getyOffset()));
                }
            }
        }
    }

    /*private void setTextureCodes(Tile[][] board) {
    
    
    
    Random random = new Random();
    
    for(int y = 0; y < height; y++) {
    for(int x = 0; x < width; x++) {
    
    Texture nature = board[x][y].getNature();
    Tile[][] tilesAround = getTilesAround(board,x,y);
    boolean NW = nature == (tilesAround[0][0] == null ? nature : tilesAround[0][0].getNature());
    boolean N = nature == (tilesAround[1][0] == null ? nature : tilesAround[1][0].getNature());
    boolean NE = nature == (tilesAround[2][0] == null ? nature : tilesAround[2][0].getNature());
    boolean E = nature == (tilesAround[2][1] == null ? nature : tilesAround[2][1].getNature());
    boolean SE = nature == (tilesAround[2][2] == null ? nature : tilesAround[2][2].getNature());
    boolean S = nature == (tilesAround[1][2] == null ? nature : tilesAround[1][2].getNature());
    boolean SW = nature == (tilesAround[0][2] == null ? nature : tilesAround[0][2].getNature());
    boolean W = nature == (tilesAround[0][1] == null ? nature : tilesAround[0][1].getNature());
    
    if(NW && N && NE && E &&  SE && S &&  SW &&  W) {
    int r = 1+random.nextInt(4);
    board[x][y].setCropCode(CropCode.CENTER_1);
    }  else if(E && SE && S && SW && W) {
    if(N && !NW) {
    board[x][y].setCropCode(CropCode.CORNER_NW);
    } else if(N && !NE) {
    board[x][y].setCropCode(CropCode.CORNER_NE);
    } else {
    board[x][y].setCropCode(CropCode.N);
    }
    }  else if(NW && N && S && SW && W) {
    
    if(E && !NE) {
    board[x][y].setCropCode(CropCode.CORNER_NE);
    } else if(E && !SE) {
    board[x][y].setCropCode(CropCode.CORNER_SE);
    } else {
    board[x][y].setCropCode(CropCode.E);
    }
    }  else if(NW && N && NE && E && W) {
    if(S && !SE) {
    board[x][y].setCropCode(CropCode.CORNER_SE);
    } else if(S && !SW) {
    board[x][y].setCropCode(CropCode.CORNER_SW);
    } else {
    board[x][y].setCropCode(CropCode.S);
    }
    
    }  else if(N && NE && E && SE && S) {
    if(W && !NW) {
    board[x][y].setCropCode(CropCode.CORNER_NW);
    } else if(W && !NE) {
    board[x][y].setCropCode(CropCode.CORNER_NE);
    } else {
    board[x][y].setCropCode(CropCode.W);
    }
    
    } else if(E && SE && S) {
    board[x][y].setCropCode(CropCode.NW);
    }else if(S && SW && W) {
    board[x][y].setCropCode(CropCode.NE);
    }else if(NW && N && W) {
    board[x][y].setCropCode(CropCode.SE);
    }else if(N && NE && E) {
    board[x][y].setCropCode(CropCode.SW);
    }else {
    if(random.nextBoolean()) {
    board[x][y].setCropCode(CropCode.BIG);
    } else {
    board[x][y].setCropCode(CropCode.SMALL);
    }
    }
    
    }
    }
    }*/
    
    
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
