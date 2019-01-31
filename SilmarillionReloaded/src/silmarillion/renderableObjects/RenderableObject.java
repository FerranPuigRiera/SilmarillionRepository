/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillion.renderableObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ferran
 *
 */
public abstract class RenderableObject {
    
    protected int width, height;
    protected boolean hovering = false;
    protected boolean delete = false;
    
    public RenderableObject(int width, int height) {
        this.width = width;
        this.height = height;
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
    
    public void setSize(int widht, int height) {
        this.width = widht;
        this.height = height;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g, float x, float y);
    public void onMouseMove(MouseEvent e, int x, int y) {
        Rectangle bounds = new Rectangle(x, y, width, height);
        hovering = bounds.contains(e.getX(), e.getY());
    }
    public void onMouseRelease(MouseEvent e) {
        if(hovering) {
            System.out.println("Clicking!");
            onClick(e);
        }
    }
    public abstract void onClick(MouseEvent e);
    
}
