/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import com.google.common.collect.ImmutableMap;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import silmarillionreloaded.gfx.GameCamera;

/**
 *
 * @author Ferran
 * @param <A>
 */
public class FreeObjectManager<A extends RenderableObject> {
    
    private final Map<A, Point> renderPoints;
    private boolean afectedByGameCamera = false;
    private GameCamera camera = null;
    
    public FreeObjectManager() {
        renderPoints = new HashMap<>();
    }
    
    public void setCamera(GameCamera camera) {
        afectedByGameCamera = true;
        this.camera = camera;
    }
    
    public void addObject(A a, Point p) {
        renderPoints.put(a, p);
    }
    public void removeObject(A a) {
        renderPoints.remove(a);
    }
    public Map<A,Point> getClonedMap() {
        return ImmutableMap.copyOf(renderPoints);
    }
    public void tickList() {
        getClonedMap().keySet().forEach(a -> {
            if(a.delete) {
                removeObject(a);
            } else {
                a.tick();
            }
        });
    }
    public void renderList(Graphics g) {
        getClonedMap().entrySet().forEach(entry -> {
            if(afectedByGameCamera) {
                entry.getKey().render(g, camera.getxOffset() + entry.getValue().x, camera.getyOffset()  + entry.getValue().y);
            } else {
                entry.getKey().render(g, entry.getValue().x, entry.getValue().y);
            }
        });
    }
    public void onMouseMoveList(MouseEvent e) {
        getClonedMap().entrySet().forEach(entry -> {
            entry.getKey().onMouseMove(e, (int)camera.getxOffset() + entry.getValue().x, (int)camera.getyOffset() + entry.getValue().y);
        });
    }
    public void onMouseReleaseList(MouseEvent e) {
        getClonedMap().keySet().forEach(a -> a.onMouseRelease(e));
    }
    
    
}
