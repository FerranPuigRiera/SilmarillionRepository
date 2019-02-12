/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import silmarillionreloaded.gfx.SpriteSheet;

/**
 *
 * @author Ferran
 */
public class SpriteAnimation extends RenderableObject {

    private List<BufferedImage> images;
    
    private boolean running = false;
    private boolean cycle = false;
    private int currentIndex = 0;
    private long delay = 100;
    private long time0;
    
    
    public SpriteAnimation(SpriteSheet sprite) {
        super(sprite.getSubImageWidth(), sprite.getSubImageHeight());
        images = new ArrayList<>();
        BufferedImage[][] spriteImages = sprite.getImages();
        for(int j = 0; j < sprite.getRows(); j++) {
            for(int i = 0; i < sprite.getColumns(); i++) {
                images.add(spriteImages[i][j]);
            }
        }
        
    }

    public List<BufferedImage> getImages() {
        return images;
    }

    public void setImages(List<BufferedImage> images) {
        this.images = images;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isCycle() {
        return cycle;
    }

    public void setCycle(boolean cycle) {
        this.cycle = cycle;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long animationDuration) {
        this.delay = animationDuration;
    }

    public long getTime0() {
        return time0;
    }

    public void setTime0(long time0) {
        this.time0 = time0;
    }

    public void start() {
        running = true;
        time0 = System.currentTimeMillis();
    }
    
    public void stop() {
        running = false;
    }
    public void delete() {
        delete = true;
    }
    
    @Override
    public void tick() {
        if(running && System.currentTimeMillis() > time0 + delay) {
            time0 = System.currentTimeMillis();
            if(currentIndex + 1 < images.size()) {
                currentIndex++;
            } else if(cycle) {
                currentIndex = 0;
            } else {
                stop();
                delete();
            }
        }
    }

    @Override
    public void render(Graphics g, float x, float y) {
        if(running) {
            g.drawImage(images.get(currentIndex), (int)x, (int)y, width, height, null);
        }
    }

    @Override
    public void onClick(MouseEvent e) {
    }
    
}
