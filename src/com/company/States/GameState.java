package com.company.States;

import com.company.Game;
import com.company.GFX.Map;
import com.company.Entity.Player;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private Map map;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        map = new Map(game, "res/maps/map1.txt");
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
