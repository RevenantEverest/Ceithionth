package com.company.States;

import com.company.Game;
import com.company.GFX.Map;
import com.company.Entity.Player;
import com.company.Handler;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private Map map;

    public GameState(Handler handler) {
        super(handler);
        map = new Map(handler, "res/maps/map1.txt");
        handler.setMap(map);
        player = new Player(handler, 100, 100);

    }

    @Override
    public void update() {
        map.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        player.render(g);
    }
}
