/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import silmarillionreloaded.renderableObjects.RenderableObject;
import silmarillionreloaded.actions.PlayableAction;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.gfx.TileImage;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.player.Player.RegularPlayer;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class Tile extends RenderableObject {
    
    public static final int TILE_WIDTH = 40;
    public static final int TILE_HEIGHT = 40;
    
    private final Game game;
    private final int coordinate;
    private final Map<Integer, TileImage> images;
    
    private Item item;
    private Piece piece;
    
    
    //Dijkstra stuff
    private List<Tile> shortestPath = new LinkedList<>();
    private Float distance = (float) Integer.MAX_VALUE;
    
    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public List<Tile> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Tile> shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    public void resetDijkstra() {
        shortestPath = new LinkedList<>();
        distance = (float) Integer.MAX_VALUE;
    }
    
    public Tile(final Game game, int coordinate) {
        super(TILE_WIDTH, TILE_HEIGHT);
        this.game = game;
        this.coordinate = coordinate;
        images = new HashMap<>();
    }

    
    public Piece getPiece() {
        return piece;
    }
    
    public int getCoordinate() {
        return coordinate;
    }
    
    public int getCoordinate_x() {
        return coordinate % World.NUMBER_COLUMNS;
    }

    public int getCoordinate_y() {
        return coordinate / World.NUMBER_COLUMNS;
    }

    public Map<Integer,TileImage> getImages() {
        return images;
    }
    
    public void addImage(int layer, TileImage image) {
        images.put(layer, image);
    }
    
    public void setPiece(final Piece piece) {
        this.piece = piece;
    }
    
    public void removePiece() {
        piece = null;
    }

    public Item getItem() {
        return item;
    }
    
    public void setItem(final Item item) {
        this.item = item;
    }
    
    public Texture getTextureOnTop() {
        return images.get(images.size() - 1).getTexture();
    }
    
    
    @Override
    public void render(Graphics g, float x, float y){
        
        
        images.entrySet().forEach((entry) -> {
        g.drawImage(entry.getValue().getImage(), (int)(game.getGameCamera().getxOffset() + x), (int)(game.getGameCamera().getyOffset() + y), width, height, null);
        
        
        if(game.selectedObject!= null && game.selectedObject.isCard() && 
                game.getCurrentPlayer().isRegularPlayer()) {
                RegularPlayer rp = (RegularPlayer)game.getCurrentPlayer();
                if(rp.getDeployTiles().contains(this) && game.selectedObject != null && rp.getValor() >= game.selectedObject.getCard().getCost()) {
                    g.setColor(rp.getAlliance().getRenderColor());
                    g.drawRect((int)(game.getGameCamera().getxOffset() + x + 2), (int)(game.getGameCamera().getyOffset() + y + 2),width - 4, height - 4);
                }
            }

            if(game.selectedObject != null && game.selectedObject.isPiece() && game.selectedObject.getPiece().getAlliance().equals(game.getCurrentPlayer().getAlliance())) {
                int pieceMoves = game.selectedObject.getPiece().getAvailableMoves();
                if(getDistance() <= pieceMoves) {
                    g.setColor(Color.yellow);
                    g.drawOval((int)(game.getGameCamera().getxOffset() + x), (int)(game.getGameCamera().getyOffset() + y), width - 1, height - 1);
                } 
            }

            //if(isTileOccupied())piece.render(g, (int)(game.getGameCamera().getxOffset() + x), (int)(game.getGameCamera().getyOffset() + y));

            if(item != null) {
                g.drawImage(Assets.TREASURE,Tile.TILE_WIDTH/2 -15 + (int)(game.getGameCamera().getxOffset() + x),Tile.TILE_HEIGHT/2 - 15 + (int)(game.getGameCamera().getyOffset() + y), 30, 30, null);
            }
        });
        
        
    }

    /*
    Overrides renderableObject.onMouseMove because it needs to add the gameCameraOffset
    */
    @Override
    public void onMouseMove(MouseEvent e, int x, int y) {
        Rectangle bounds = new Rectangle(x + (int)game.getGameCamera().getxOffset(), y + (int)game.getGameCamera().getyOffset(), width, height);
        hovering = bounds.contains(e.getX(), e.getY());
    }
    
    public boolean isTileOccupied() {
        return piece != null;
    }
    
    public boolean tileHasItem() {
        return item != null;
    }

    @Override
    public void tick() {
        if(piece != null) {
            piece.tick();
        }
    }

    @Override
    public void onClick(MouseEvent e) {
        
        Player currentPlayer = game.getCurrentPlayer();
        
        if(!currentPlayer.getVision().contains(this)) {
            return;
        }
        
        if(currentPlayer.isRegularPlayer()) {
            RegularPlayer rp = (RegularPlayer)currentPlayer;
            
            if(rp.isHovering() || rp.getInventory().isHovering() || rp.getHand().isHovering()) {
                return;
            }
            if(e.getButton() == MouseEvent.BUTTON1) {
                
                if(isTileOccupied()) {
                    piece.onClick(e);
                }
            } else if(e.getButton() == MouseEvent.BUTTON3) {
                if(isTileOccupied()) {
                    piece.onClick(e);
                } else {
                    if(game.selectedObject != null) {
                        if(game.selectedObject.isCard()) {
                            PlayableAction.USE_SUMMON_CARD.execute(this);
                        } else if(game.selectedObject.isPiece()) {
                            PlayableAction.MOVE_PIECE.execute(this);
                        }
                    } 
                }
                
            }
            
        }
    }
}
