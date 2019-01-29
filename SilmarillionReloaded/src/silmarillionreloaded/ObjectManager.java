/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded;

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
    private final int listCapacity;
    
   
    public ObjectManager(int capacity) {
        super(0,0,0,0);
        list = new ArrayList<>();
        listCapacity = capacity;
    }
    public ObjectManager(float x, float y, int width, int height, int capacity) {
        super(x,y,width,height);
        list = new ArrayList<>();
        listCapacity = capacity;
    }
    public ObjectManager(int width, int height, int capacity) {
        super(0,0,width,height);
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
        getCloneList().forEach(object -> object.tick());
    }
    public void renderList(Graphics g) {
        getCloneList().forEach(object -> object.render(g));
    }
    public void onMouseMoveList(MouseEvent e) {
        getCloneList().forEach(object -> object.onMouseMove(e));
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
    
}
