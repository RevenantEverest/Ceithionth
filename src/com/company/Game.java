package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Game implements  Runnable{

    private Display display;
    private String title;
    private int width, height;

    private boolean running;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    private void init() {
        display = new Display(title, width, height);
    }

    private void update() {

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0, width, height);
        //Draw Here



        //END

        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        while(running) {
            update();
            render();
        }

        stop();
    }

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
