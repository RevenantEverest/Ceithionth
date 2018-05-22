package com.company;

import java.awt.Graphics;

public class GameState extends State{

    private Player player;
    private Map map;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        map = new Map("");
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
