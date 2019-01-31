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
public class PanelManager<A extends Panel> {

    private final List<A> list;
    
    public PanelManager() {
        list = new ArrayList<>();
    }

    public List<A> getCloneList() {
        return ImmutableList.copyOf(list);
    }
    
    public boolean addObject(A object) {

        list.add(object);
        return true;
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
        for(int i = 0; i < list.size(); i++) {
            getCloneList().get(i).render(g);
        }
    }
    public void onMouseMoveList(MouseEvent e) {
        for(int i = 0; i < list.size(); i++) {
            A a = getCloneList().get(i);
            a.onMouseMove(e, (int)a.x, (int)a.y);
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
    
}
