/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import silmarillionreloaded.Application;
import silmarillionreloaded.entity.Entity;

/**
 *
 * @author Ferran
 */
public class GameCamera {
    
    private Application app;
    private float xOffset, yOffset;
    
    public GameCamera(Application app, float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - Application.FRAME_WIDTH / 2 + e.getWidth() / 2;
        yOffset = e.getY() - Application.FRAME_HEIGHT / 2 + e.getHeight() / 2; 
    }
    
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }
    
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
