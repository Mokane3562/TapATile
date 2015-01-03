package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;

/**
 * Created by scott on 2015-01-03.
 */
public class PointTile extends Tile{
    private ActivePointTile activePointTile;
    private InactivePointTile inactivePointTile;
    private KillTile killTile;
    private MultTile multTile;
    private boolean active;
    private boolean special;
    private float delay, baseDelay;
    public PointTile(Vector2 pos, OrthoCamera camera) {
        super(null, pos, camera);
        baseDelay =60000/(GameScreen.bpm);
        baseDelay = (Math.abs(GameScreen.bpm-120) <= Math.abs(GameScreen.bpm/2 - 120)) ? baseDelay : baseDelay * 2;
        delay = baseDelay;
        activePointTile = new ActivePointTile(pos, camera);
        inactivePointTile = new InactivePointTile(pos, camera);
        killTile = new KillTile(pos, camera);
        multTile = new MultTile(pos, camera);
        active = false;
        special = false;
    }

    @Override
    public void update() {

    }

    public boolean isSpecial() {
        return special;
    }
    public void setSpecial(boolean special) {
        delay = baseDelay;
        this.special = special;
    }

    public void render(SpriteBatch sb,float delta){

        if(delta > baseDelay) {
            special = false;
            active = false;
            delay = baseDelay;
            inactivePointTile.render(sb);
        }
        if(special) {
            if(active) {
                multTile.render(sb);
            }
            else {
                killTile.render(sb);
            }
        }
        else {
            if (active) {
                activePointTile.render(sb);
            } else {
                inactivePointTile.render(sb);

            }
        }

    }

    public void activate(){
        delay = baseDelay;
        active = true;
    }
    public void deactivate(){
        delay = baseDelay;
        active = false;
    }
    public boolean containsPoint(Vector2 point){
        if(active) {
            this.deactivate();
            return activePointTile.containsPoint(point);
        }
        else
            return inactivePointTile.containsPoint(point);
    }
}
