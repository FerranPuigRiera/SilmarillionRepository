/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Ferran
 */
public class KeyManager implements KeyListener{

    public boolean[] keys;
    
    public boolean up, down, left, right;
    
    public KeyManager() {
        keys = new boolean[1024];
    }
    
    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
