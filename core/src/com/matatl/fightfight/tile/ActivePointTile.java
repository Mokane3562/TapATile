package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.AudioManager;
import com.matatl.fightfight.ScoreManager;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class ActivePointTile extends Tile{
    public ActivePointTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.POINT_TILE, pos, camera);
    }

    @Override
    public void handleTouch(Vector2 touch) {
        if (this.containsPoint(touch)){
            AudioManager.POINT_TILE_FX.play(5);
            ScoreManager.incrementScore();
        }
    }

    public void update() {

    }
}
