package com.company;

import java.awt.Graphics;

public class Map {

    private int width, height;
    private int[][] tiles;

    public Map(String path) {
        loadMap(path);
    }

    public void update() {

    }

    public void render(Graphics g) {
        for(int y  = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }

    private void loadMap(String path) {

    }
}
