/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Random;
import silmarillion.renderableObjects.ObjectManager;
import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.input.MouseManager;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.tiles.Tile;

import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public class World extends ObjectManager<Tile>{
    
    public static final int NUMBER_COLUMNS = 55;
    public static final int NUMBER_ROWS = 30;
    
    

    private final int columns, rows;

    public World() {
        super(0,0,NUMBER_COLUMNS*Tile.TILE_WIDTH,NUMBER_ROWS*Tile.TILE_HEIGHT, NUMBER_COLUMNS, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, NUMBER_COLUMNS*NUMBER_ROWS);     
        columns = NUMBER_COLUMNS;
        rows = NUMBER_ROWS;
        WorldGenerator generator = new WorldGenerator(this);
        generator.getGeneratedWorld().forEach(tile -> addObject(tile));
        getCloneList().forEach(tile -> tile.setItem(Item.getNewRandomItemOrNot()));
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
    
    
    public void onMouseMoveTiles(MouseEvent e) {
        
        for(int i = 0; i < getSize(); i++) {
            getCloneList().get(i).onMouseMove(e, (i % columns)*Tile.TILE_WIDTH, (i / columns)*Tile.TILE_HEIGHT);
        }
        
        getCloneList().forEach(tile -> tile.onMouseMove(e, 0, 0));
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
        Rectangle outerRect = new Rectangle(0,0,width,height);
        Rectangle innerRect = new Rectangle(width/4,height/4,width/2,height/2);
        MouseManager mm = Application.INSTANCE.getMouseManager();
        if(outerRect.contains(mm.getMouseX(), mm.getMouseY()) && 
           !innerRect.contains(mm.getMouseX(),mm.getMouseY())) {
            
            if(mm.getMouseX() < innerRect.x) {
                Game.INSTANCE.getGameCamera().move(-1, 0);
            } else if(mm.getMouseX() > innerRect.x + innerRect.width) {
                Game.INSTANCE.getGameCamera().move(1, 0);
            }
            if(mm.getMouseY() < innerRect.y) {
                Game.INSTANCE.getGameCamera().move(0, -1);
            } else if(mm.getMouseY() > innerRect.y + innerRect.height) {
                Game.INSTANCE.getGameCamera().move(0, 1);
            }
            
            
        }
    }

    @Override
    public void render(Graphics g, float x, float y) {

    }

    @Override
    public void onClick(MouseEvent e) {
        System.out.println("Click on world");
    }

    @Override
    public boolean showList() {
        return true;
    }
}
