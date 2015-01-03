package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class ActivePointTile extends Tile{
    public ActivePointTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.POINT_TILE, pos, camera);
    }
    public void update() {

    }
}
