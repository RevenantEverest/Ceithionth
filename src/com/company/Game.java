package com.company;

import com.company.GFX.Assets;
import com.company.GFX.Display;
import com.company.States.GameState;
import com.company.States.MenuState;
import com.company.States.State;
import com.company.Utils.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements  Runnable{

    private Display display;
    private String title;
    private int width, height;

    private boolean running;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameCamera = new GameCamera(this, 0, 0);

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }

    private void update() {
        keyManager.update();

        if(State.getState() != null) {
            State.getState().update();
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
        g.clearRect(0, 0, width, height);
        //Draw Here

        if(State.getState() != null) {
            State.getState().render(g);
        }

        //END

        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000) {
//                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    //Getters
    public KeyManager getKeyManager() { return keyManager; }
    public GameCamera getGameCamera() { return gameCamera; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    /* END */

    public synchronized void start() {
        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
