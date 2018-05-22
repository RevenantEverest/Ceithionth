package com.company.GFX;

import com.company.Game;
import com.company.Handler;
import com.company.Utils.Utils;

import java.awt.Graphics;

public class Map {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public Map(Handler handler, String path) {
        this.handler = handler;
        loadMap(path);
    }

    public void update() {

    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getXOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILE_HEIGHT  + 1);

        for(int y  = yStart; y < yEnd; y++) {
            for(int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getXOffset()),
                        (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getYOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }

    private void loadMap(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
}