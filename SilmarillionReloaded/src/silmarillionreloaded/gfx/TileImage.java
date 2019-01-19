/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import java.awt.image.BufferedImage;
import silmarillionreloaded.tiles.Texture;

/**
 *
 * @author Ferran
 */
public class TileImage {
    
    private final Texture texture;
    private final int row;
    private final int column;
    
    public TileImage(Texture texture, CropCode cropCode) {
        this.texture = texture;
        column = cropCode.getXonSpriteSheet();
        row = cropCode.getYonSpriteSheet();
    }
    
    public TileImage(Texture texture, int x, int y) {
        this.texture = texture;
        row = y;
        column = x;
    }
    
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    
    public Texture getTexture() {
        return texture;
    }
    public BufferedImage getImage() {
        return texture.getSpriteSheet().getSubImage(column, row);
    }
    
    
}
