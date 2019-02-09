/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import silmarillionreloaded.game.Game;

/**
 *
 * @author Ferran
 */
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    
    private Game game;
    
    
    public MouseManager() {
    }

    public void addGame(final Game game) {
        this.game = game;
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
        if(me.getButton() == MouseEvent.BUTTON3) {
            leftPressed = true;
        } else if(me.getButton() == MouseEvent.BUTTON1) {
            rightPressed = true;
        }     
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON3) {
            leftPressed = false;
        } else if(me.getButton() == MouseEvent.BUTTON1) {
            rightPressed = false;
        }
        if(game != null) {
            game.getCurrentPlayer().onMouseReleaseElements(me);
            game.getWorld().onMouseReleaseList(me);
            game.getPanelManager().onMouseReleaseList(me);
            game.getEndTurnButton().onMouseRelease(me);
            game.getCollectButton().onMouseRelease(me);
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
        if(game != null) {
            game.getCurrentPlayer().onMouseMoveElements(me);
            game.getWorld().onMouseMoveList(me);
            game.getPanelManager().onMouseMoveList(me);
            game.getEndTurnButton().onMouseMove(me, 1500, 800);
            game.getCollectButton().onMouseMove(me, 1500, 700);
        }
    }
    
    
    
}
