package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.ScoreManager;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.MenuScreen;
import com.matatl.fightfight.screen.ScreenManager;

/**
 * Created by scott on 2015-01-03.
 */
public class InactivePointTile extends Tile {


    public InactivePointTile(Vector2 pos, OrthoCamera camera) {
        super(TextureManager.INACTIVE_POINT_TILE, pos, camera);
    }

    @Override
    public void handleTouch(Vector2 touch) {
        if (this.containsPoint(touch)){
            if(ScoreManager.safe())
                ScoreManager.resetMultiplier();
            else
                ScreenManager.setScreen(new MenuScreen());
        }
    }

    @Override
    public void update() {

    }
}
