/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderableObjects;

import com.google.common.collect.ImmutableList;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Ferran
 * @param <A>
 */
public abstract class ObjectManager<A extends RenderableObject> extends RenderableObject {
    
    private final List<A> list;
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
    }
    
    public List<A> getCloneList() {
        return ImmutableList.copyOf(list);
    }
    
    public boolean addObject(A object) {
        if(list.size() < listCapacity) {
            list.add(object);
            return true;
        } 
        return false;
    }
    public boolean removeObject(A object) {
        return list.remove(object);
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
            for(int i = 0; i < list.size(); i++) {
                getCloneList().get(i).render(g, x + (i % columns)*objectWidth, y + (i / columns)*objectHeight);
            }
        }
    }
    public void onMouseMoveList(MouseEvent e) {
        for(int i = 0; i < list.size(); i++) {
            getCloneList().get(i).onMouseMove(e, (int)x + (i % columns)*objectWidth, (int)y + (i / columns)*objectHeight);
        }
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
