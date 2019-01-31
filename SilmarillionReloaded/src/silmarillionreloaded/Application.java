/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded;

import silmarillionreloaded.display.Display;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.input.KeyManager;
import silmarillionreloaded.input.MouseManager;
import silmarillionreloaded.states.GameState;
import silmarillionreloaded.states.MenuState;
import silmarillionreloaded.states.State;

/**
 *
 * @author Ferran
 */
public class Application implements Runnable{

    public static Application INSTANCE;
    
    public static final String FRAME_TITLE = "Silmarillion Reloaded";
    public static final int FRAME_WIDTH = 1800;
    public static final int FRAME_HEIGHT = 1000;
    
    
    private Display display;
    
    private Thread thread;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private GameState gameState;
    private MenuState menuState;
    
    //Input
    private final KeyManager keyManager;
    private final MouseManager mouseManager;

    //Game game
    
    private Game game;
    
    
    public Application(){
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        INSTANCE = this;
    }
    
    public void createGame() {
        game = new Game(this);
    }
    
    public Game getGame() {
        return game;
    }
    
    private void init() {
        display = new Display(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }
    
    private void tick() {
        if(State.getState() != null) {
            State.getState().tick();
        }
    }
    
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        //Draw
        if(State.getState() != null) {
            State.getState().render(g);
        }
        //End Draw
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000) {
                System.out.println("FPS : "+ticks);
                ticks = 0;
                timer = 0;
            }
            
        }
    }
    
    public synchronized void start() {
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
       
    }
    public synchronized void stop() {
        if(!running) 
            return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
}
