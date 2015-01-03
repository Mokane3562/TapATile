package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.TextureManager;

/**
 * Created by Philip on 1/3/2015.
 */
public class MultTile extends Tile {
    public MultTile(TileManager tileManager,Vector2 pos) {
        super(TextureManager.MULT_TILE,pos);
    }
    public void update() {

    }
}
