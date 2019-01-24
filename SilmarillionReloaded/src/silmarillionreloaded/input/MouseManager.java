/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import silmarillionreloaded.Application;
import silmarillionreloaded.states.State;

/**
 *
 * @author Ferran
 */
public class MouseManager implements MouseListener, MouseMotionListener{

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    
    
    public MouseManager() {
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if(me.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }     
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        } else if(me.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }
        
        if(State.getState().getUIManager() != null) {
            State.getState().getUIManager().onMouseRelease(me);
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        
        if(State.getState().getUIManager() != null) {
            State.getState().getUIManager().onMouseMove(me);
        }
        
    }
    
    
    
}
