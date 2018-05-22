package com.company;

import com.company.GFX.Map;
import com.company.Utils.KeyManager;

public class Handler {

    private Game game;
    private Map map;

    public Handler(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() { return game.getKeyManager(); }
    public GameCamera getGameCamera() { return game.getGameCamera(); }

    public int getWidth() { return game.getWidth(); }
    public int getHeight() { return game.getHeight(); }

    public Game getGame() { return game; }
    public Map getMap() { return map; }

    public void setGame(Game game) { this.game = game; }
    public void setMap(Map map) { this.map = map; }
}
