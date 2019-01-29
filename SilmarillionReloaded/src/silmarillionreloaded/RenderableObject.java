/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ferran
 *
 */
public abstract class RenderableObject {
    
    protected float x,y;
    protected int width, height;
    protected boolean hovering = false;
    protected Rectangle bounds;
    
    public RenderableObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int)x,(int)y,width,height);
    }
    
    public RenderableObject(int widht, int height) {
        this.x = 0;
        this.y = 0;
        this.width = widht;
        this.height = height;
        bounds = new Rectangle(0,0,width,height);
        
    }
    public RenderableObject() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        bounds = new Rectangle(0,0,0,0);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setSize(int widht, int height) {
        this.width = widht;
        this.height = height;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public void onMouseMove(MouseEvent e) {
        hovering = bounds.contains(e.getX(), e.getY());
    }
    public void onMouseRelease(MouseEvent e) {
        if(hovering) {
            onClick();
        }
    }
    public abstract void onClick();
    
}
