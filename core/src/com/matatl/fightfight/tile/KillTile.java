package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.ScoreManager;
import com.matatl.fightfight.SoundManager;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;
import com.matatl.fightfight.screen.MenuScreen;
import com.matatl.fightfight.screen.ScreenManager;

/**
 * Created by Philip on 1/3/2015.
 */
public class KillTile extends Tile{
    public KillTile(Vector2 pos,OrthoCamera camera) {
        super(TextureManager.KILL_TILE,pos,camera);
    }
    public void update() {

    }
    public void handleTouch(Vector2 touch){
        if (this.containsPoint(touch)){
            SoundManager.KILL_TILE_FX.play();
            ScreenManager.setScreen(new MenuScreen());
        }
    }
}
