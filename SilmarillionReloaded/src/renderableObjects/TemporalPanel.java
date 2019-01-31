/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderableObjects;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ferran
 * @param <A>
 */
public class TemporalPanel<A extends RenderableObject> extends Panel{

    private final int duration;
    private final Panel panel;
    
    
    private final long time0;
    private long currentTime;
   
    
    public TemporalPanel(Panel panel, int duration) {
        super(panel.object,panel.x,panel.y,panel.width, panel.height);
        this.duration = duration;
        this.panel = panel;
        time0 = System.currentTimeMillis();
        currentTime = System.currentTimeMillis();
    }

    
    
    @Override
    public void tick() {
        if(currentTime >= duration + time0) {
            delete = true;
        } else {
            panel.tick();
            currentTime = System.currentTimeMillis();
        }
    }

    @Override
    public void render(Graphics g) {
        panel.render(g);
    }

    @Override
    public void onClick(MouseEvent e) {
        object.onClick(e);
    }
    
}
