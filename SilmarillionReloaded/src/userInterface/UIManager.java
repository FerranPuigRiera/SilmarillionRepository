/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import silmarillionreloaded.Application;

/**
 *
 * @author Ferran
 */
public class UIManager {
    
    private final Application app;
    private final ArrayList<UIObject> objects;
    
    public UIManager(Application app) {
        this.app = app;
        objects = new ArrayList<>();
    }
    
    public void tick() {
        objects.forEach(o -> o.tick());
    }
    
    public void render(Graphics g) {
        objects.forEach(o -> o.render(g));
    } 
    
    public void onMouseMove(MouseEvent e) {
        objects.forEach(o -> o.onMouseMove(e));
    }
    
    public void onMouseRelease(MouseEvent e) {
        objects.forEach(o -> o.onMouseRelease(e));
    }
    
    public void addObject(UIObject o) {
        objects.add(o);
    }
    
    public void removeObject(UIObject o) {
        objects.remove(o);
    }
    
}
