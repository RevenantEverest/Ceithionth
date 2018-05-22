package com.company.GFX;

import com.company.GFX.Assets;
import com.company.GFX.Tile;

public class TreeTile extends Tile {

    public TreeTile(int id) {
        super(Assets.treeOnGrass, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
