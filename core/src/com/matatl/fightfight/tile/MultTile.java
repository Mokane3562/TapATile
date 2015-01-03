package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class MultTile extends Tile {
    public MultTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.MULT_TILE,pos,camera);
    }
    public void update() {

    }
}
