/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.renderableObjects.ObjectManager;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.tiles.Tile;

import silmarillionreloaded.worlds.worldElements.WorldGenerator;

/**
 *
 * @author Ferran
 */
public final class World extends ObjectManager<Tile>{
    
    public static final int NUMBER_COLUMNS = 55;
    public static final int NUMBER_ROWS = 30;
    
    

    private final int rows;
    
    public World() {
        super(0,0,NUMBER_COLUMNS*Tile.TILE_WIDTH,NUMBER_ROWS*Tile.TILE_HEIGHT, NUMBER_COLUMNS, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, NUMBER_COLUMNS*NUMBER_ROWS);     
        rows = NUMBER_ROWS;
        WorldGenerator generator = new WorldGenerator(this);
        setDefaultRenderPoints();
        generator.getGeneratedWorld().forEach(tile -> addObject(tile));
        getCloneList().forEach(tile -> tile.setItem(Item.getNewRandomItemOrNot()));
    }
    
    public Tile findTilesPieceOnWorld(final Piece piece) {
        for(Tile tile : getCloneList()) {
            if(tile.isTileOccupied() && tile.getPiece().equals(piece)) {
                return tile;
            }
        }
        throw new RuntimeException("Piece not found!");
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
    
    public Tile getTile(int coordinate) {
        return getCloneList().get(coordinate);
    }
    public Tile getTile(int x_coordinate, int y_coordinate) {
        return getCloneList().get(y_coordinate*columns + x_coordinate);
    }
    
    public void onMouseMoveTiles(MouseEvent e) {
        
        for(int i = 0; i < getSize(); i++) {
            getCloneList().get(i).onMouseMove(e, (i % columns)*Tile.TILE_WIDTH, (i / columns)*Tile.TILE_HEIGHT);
        }
        
        getCloneList().forEach(tile -> tile.onMouseMove(e, 0, 0));
    }
    
    public Set<Tile> getTilesAround(Tile tile) {
        if(tile == null) {
            throw new RuntimeException("Null Tile");
        }
        Set<Tile> tilesAround = new LinkedHashSet<>();
        
        int coord_x = tile.getCoordinate_x();
        int coord_y = tile.getCoordinate_y();
       
        if(coord_x + 1 < columns)tilesAround.add(getTile(coord_x + 1, coord_y));
        if(coord_y + 1 < rows )tilesAround.add(getTile(coord_x, coord_y + 1));
        if(coord_x - 1 >= 0)tilesAround.add(getTile(coord_x - 1, coord_y));
        if(coord_y - 1 >= 0)tilesAround.add(getTile(coord_x, coord_y - 1));
        if(coord_x + 1 < columns && coord_y + 1 < rows)tilesAround.add(getTile(coord_x + 1, coord_y + 1));
        if(coord_x - 1 >= 0 && coord_y + 1 < rows )tilesAround.add(getTile(coord_x - 1, coord_y + 1));
        if(coord_x + 1 < columns && coord_y - 1 >= 0)tilesAround.add(getTile(coord_x + 1, coord_y - 1));
        if(coord_x - 1 >= 0 && coord_y - 1 >= 0)tilesAround.add(getTile(coord_x - 1, coord_y - 1));
        return tilesAround;
    } 
    
    public Map<Tile,Float> getTilesAroundDistances(final Tile tile) {
        HashMap<Tile, Float> map = new HashMap<>();
        if(tile == null) {
            throw new RuntimeException("Null tile 2");
        }
        getTilesAround(tile).stream().filter(tileAround -> tileAround != null).forEach(tileAround -> {
            if(tileAround.isTileOccupied()) {
                map.put(tileAround, 100000f);
            } else if(tile.getCoordinate_x() == tileAround.getCoordinate_x() || tile.getCoordinate_y() == tileAround.getCoordinate_y()) {
                map.put(tileAround, (float)tileAround.getTextureOnTop().movementCost());
            } else {
                map.put(tileAround, (float) (tileAround.getTextureOnTop().movementCost()*Math.sqrt(2)));
            }
            
        });
        return map;
    }
    @Override
    public void renderList(Graphics g) {
        getCloneList().forEach(tile -> tile.render(g, renderPoints.get(tile).x, renderPoints.get(tile).y));
        getCloneList().stream().filter(tile -> tile.isTileOccupied()).forEach(tile -> tile.getPiece().render(g, renderPoints.get(tile).x, renderPoints.get(tile).y));
        /*getCloneList().stream().filter(tile -> !Game.INSTANCE.getCurrentPlayer().getVision().contains(tile)).forEach(tile -> {
        g.setColor(Color.black);
        g.fillRect(renderPoints.get(tile).x, renderPoints.get(tile).y,width, height);
        });*/
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g, float x, float y) {

    }

    @Override
    public void onClick(MouseEvent e) {
    }

    @Override
    public boolean showList() {
        return true;
    }
    
    
    public void calculateShortestPathFromSource(final Tile source) {
        source.setDistance(0);
        
        Set<Tile> settledNodes = new HashSet<>();
        Set<Tile> unsettledNodes = new HashSet<>();
        
        unsettledNodes.add(source);
        
        while(unsettledNodes.size() > 0) {
            Tile currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            if(currentNode == null) {
                break;
            }
            getTilesAroundDistances(currentNode).entrySet().forEach(pair -> {
                Tile adjacentNode = pair.getKey();
                float edgeWeight = pair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }    
            
            });
            settledNodes.add(currentNode);
        }
        
    }
    
    private Tile getLowestDistanceNode(Set<Tile> unsettledNodes) {
        Tile lowestDistanceNode = null;
        float lowestDistance = Integer.MAX_VALUE;
        for(Tile node : unsettledNodes) {
            float nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    
    
    private void calculateMinimumDistance(Tile evaluationNode, float edgeWeigh, Tile sourceNode) {
        float sourceDistance = sourceNode.getDistance();
        if(sourceDistance + (int)edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Tile> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }   
    }
    
}
