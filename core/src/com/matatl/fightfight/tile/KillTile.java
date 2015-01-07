package com.matatl.fightfight.tile;

import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.util.AudioManager;
import com.matatl.fightfight.util.TextureManager;
import com.matatl.fightfight.util.OrthoCamera;
import com.matatl.fightfight.screen.MenuScreen;
import com.matatl.fightfight.util.ScreenManager;

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
            AudioManager.KILL_TILE_FX.play();
            ScreenManager.setScreen(new MenuScreen());
        }
    }
}
