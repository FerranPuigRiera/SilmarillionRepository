/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ferran
 */
public class SpriteSheet {
    
    private final BufferedImage sheet;
    private final BufferedImage[][] images;
    private final int columns;
    private final int rows;
    private final int subImageWidth;
    private final int subImageHeight;
    
    public SpriteSheet(BufferedImage sheet, int columns, int rows) {
        this.sheet = sheet;
        this.columns = columns;
        this.rows = rows;
        images = new BufferedImage[columns][rows];
        subImageWidth = sheet.getWidth() / columns;
        subImageHeight = sheet.getHeight() / rows;
        cropImages();
    }
    
    public BufferedImage getSheet() {
        return sheet;
    }
    
    public SpriteSheet createSubSpriteSheet(int column, int row, int width, int height) {
        return new SpriteSheet(crop(column, row, width, height), width, height);
    }

    public BufferedImage[][] getImages() {
        return images;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getSubImageWidth() {
        return subImageWidth;
    }

    public int getSubImageHeight() {
        return subImageHeight;
    }
   
    
    
    private BufferedImage crop(int column, int row, int size_x, int size_y) {
        return sheet.getSubimage(column*subImageWidth, row*subImageHeight, size_x*subImageWidth, size_y*subImageHeight);
    }
    private BufferedImage crop(int column, int row) {
        return sheet.getSubimage(column*subImageWidth, row*subImageHeight,subImageWidth,subImageHeight);
    }

    private void cropImages() {
        for(int j = 0; j < rows; j++) {
            for(int i = 0; i < columns; i++) {
                images[i][j] = crop(i,j);
            }
        }
    }
    
    public BufferedImage getSubImage(int column, int row) {
        return images[column][row];
    }
    
    public void saveSubImages() {
        
        for(int j = 0; j < rows; j++) {
            for(int i = 0; i < columns; i++) {
                BufferedImage img = images[i][j];
                File file = new File("image["+i+"]["+j+"].png");
                try {
                    ImageIO.write(img, "PNG", file);
                    System.out.println("Image Saved!");
                } catch (IOException ex) {
                    Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        System.out.println("All images saved");
        
    }
    
    
}
