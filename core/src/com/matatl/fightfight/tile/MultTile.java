package com.matatl.fightfight.tile;

import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.util.AudioManager;
import com.matatl.fightfight.util.ScoreManager;
import com.matatl.fightfight.util.TextureManager;
import com.matatl.fightfight.util.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class MultTile extends Tile {
    public MultTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.MULT_TILE,pos,camera);
    }
    public void update() {
    }

    @Override
    public void handleTouch(Vector2 touch) {
        if (this.containsPoint(touch)){
            AudioManager.MULT_TILE_FX.play();
            ScoreManager.incrementMultiplier();
            ScoreManager.incrementScore();
        }
    }
}
