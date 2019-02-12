/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import com.google.common.collect.ImmutableList;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Ferran
 * @param <A>
 */
public abstract class ObjectManager<A extends RenderableObject> extends RenderableObject {
      
    private final List<A> list;
    protected final Map<A, Point> renderPoints;
    protected final int listCapacity;
    
    protected final int columns;
    
    protected final float x;
    protected final float y;
    protected final int objectWidth;
    protected final int objectHeight;
    

    
    
    
    public ObjectManager(float x, float y, int width, int height,int columns, int objectWidth, int objectHeight, int capacity) {
        super(width,height);
        this.x = x;
        this.y = y;
        this.columns = columns;
        this.objectWidth = objectWidth;
        this.objectHeight = objectHeight;
        list = new ArrayList<>();
        listCapacity = capacity;
        renderPoints = new LinkedHashMap<>();
    }
    
    public void setDefaultRenderPoints() {
        int i = 0;
        for(A object : list) {
            int coord_x = i % columns;
            int coord_y = i / columns;
            Point p = new Point((int)x + coord_x*objectWidth,(int)y + coord_y*objectHeight);
            renderPoints.put(object, p);
            i++;
        }
    }
    
    public void moveRenderPointOnTime(A object, Point p, long time) {
        
    }
    
    
    public Point getRenderPoint(A object) {
        return renderPoints.get(object);
    }
    
    public void setRenderPoint(A object, Point p) {
        renderPoints.replace(object, p);
    }
    
    public List<A> getCloneList() {
        return ImmutableList.copyOf(list);
    }
    
    public void moveObject(A object, Point p) {
        renderPoints.replace(object, p);
    }
    
    public boolean addObject(A object) {
        if(list.size() < listCapacity) {
            list.add(object);
            setDefaultRenderPoints();
            return true;
        } 
        return false;
    }
    public boolean removeObject(A object) {
        if(list.remove(object)) {
            setDefaultRenderPoints();
            return true;
        }
        return false;
    }    
    public void tickList() {
        getCloneList().forEach(object -> {
            if(object.delete) {
                list.remove(object);
            }
            object.tick();
        });
    }
    public void renderList(Graphics g) {
        if(showList()) {
            getCloneList().forEach(object -> object.render(g, renderPoints.get(object).x, renderPoints.get(object).y));
        }
    }
    public void onMouseMoveList(MouseEvent e) {
            getCloneList().forEach(object -> object.onMouseMove(e, renderPoints.get(object).x, renderPoints.get(object).y));

    }
    public void onMouseReleaseList(MouseEvent e) {
        getCloneList().forEach(object -> object.onMouseRelease(e));
    }
    public int getIndexOf(A object) {
        return list.indexOf(object);
    }
    public A get(int index) {
        return list.get(index);
    }
    public boolean contains(A object) {
        return list.contains(object);
    }
    public int getSize() {
        return list.size();
    }
    public void shuffleList() {
        Collections.shuffle(list);
    }
    
    public abstract boolean showList();
    
}
