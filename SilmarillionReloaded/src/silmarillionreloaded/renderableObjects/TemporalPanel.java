/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import silmarillionreloaded.Application;
import silmarillionreloaded.game.Game;

/**
 *
 * @author Ferran
 * @param <A>
 */
public class TemporalPanel<A extends RenderableObject> extends Panel{

    private final int duration;
    private final Panel panel;
    
    
    private long time0;
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
               
        if(hovering) {
            time0 = System.currentTimeMillis();
            currentTime = System.currentTimeMillis();
        } else {
            if(currentTime >= duration + time0) {
                delete = true;
            } else {
                panel.tick();
                currentTime = System.currentTimeMillis();
            }
        }
        
    }

    @Override
    public void onMouseMove(MouseEvent e, int x, int y) {
        Rectangle bounds = new Rectangle(x, y, width, height);
        hovering = bounds.contains(e.getX(), e.getY());
    }
    
    
    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        panel.render(g);
    }

    @Override
    public void onClick(MouseEvent e) {
        object.onClick(e);
    }
    

    public static void addErrorMessage(String error) {
        int panelX = Application.FRAME_WIDTH / 2 - 100;
        int panelY =  Application.FRAME_HEIGHT / 2 - 200;
        NormalPanel panel = new NormalPanel(panelX,panelY, 150, 20) {
            @Override
            public void tick() {
            }

            @Override
            public void render(Graphics g) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial",Font.PLAIN, 26));
                g.drawString(error, (int)panelX,(int)panelY);
            }

            @Override
            public void onClick(MouseEvent e) {
            }
        };

        TemporalPanel tp = new TemporalPanel(panel, 1000);
        Game.INSTANCE.getPanelManager().addObject(tp);
    }
    
    public static void addMessage(String message) {
        int panelX = Application.FRAME_WIDTH / 2 - 100;
        int panelY =  Application.FRAME_HEIGHT / 2 - 200;
        NormalPanel panel = new NormalPanel(panelX,panelY, 150, 20) {
            @Override
            public void tick() {
            }

            @Override
            public void render(Graphics g) {
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Arial",Font.PLAIN, 26));
                g.drawString(message, (int)panelX,(int)panelY);
            }

            @Override
            public void onClick(MouseEvent e) {
            }
        };

        TemporalPanel tp = new TemporalPanel(panel, 1000);
        Game.INSTANCE.getPanelManager().addObject(tp);
    }
    
    
    
}
