package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by scott on 2015-01-03.
 */
public class InactivePointTile extends Tile {


    public InactivePointTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.INACTIVE_POINT_TILE, pos, camera);
    }

    @Override
    public void update() {

    }
}
