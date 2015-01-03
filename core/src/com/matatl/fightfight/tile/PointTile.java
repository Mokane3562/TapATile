package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;

import javax.xml.soap.Text;

/**
 * Created by scott on 2015-01-03.
 */
public class PointTile extends Tile{
    private boolean active;
    private boolean special;
    private float delay, baseDelay;
    public PointTile(Vector2 pos, OrthoCamera camera) {
        super(null, pos, camera);
        baseDelay =60000/(GameScreen.bpm);
        baseDelay = (Math.abs(GameScreen.bpm-120) <= Math.abs(GameScreen.bpm/2 - 120)) ? baseDelay : baseDelay * 2;
        delay = baseDelay;
        active = false;
        special = false;
        texture = TextureManager.INACTIVE_POINT_TILE;
    }

    @Override
    public void update() {
        if(special) {
            if(active) {
                texture = TextureManager.MULT_TILE;
            }
            else {
                texture = TextureManager.KILL_TILE;
            }
        }
        else {
            if(active) {
                texture = TextureManager.POINT_TILE;

            }
            else {
                texture = TextureManager.INACTIVE_POINT_TILE;
            }
        }
    }

    public boolean isSpecial() {
        return special;
    }
    public void setSpecial(boolean special) {
        delay = baseDelay;
        this.special = special;
    }

    public void render(SpriteBatch sb,float delta){
        delay -= delta;
        if(delay >= 0) {
            special = false;
            active = false;
            delay = baseDelay;
        }
        this.update();
        super.render(sb);

    }

    public boolean isActive() {
        return active;
    }
    public void activate(){
        delay = baseDelay;
        active = true;
    }
    public void deactivate(){
        delay = baseDelay;
        active = false;
    }

}
