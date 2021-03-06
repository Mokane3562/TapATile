package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.util.ScoreManager;
import com.matatl.fightfight.util.TextureManager;
import com.matatl.fightfight.util.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;
import com.matatl.fightfight.screen.MenuScreen;
import com.matatl.fightfight.util.ScreenManager;

/**
 * Created by scott on 2015-01-03.
 */
public class PointTile extends Tile{
    private boolean active;
    private boolean special;
    private float delay, baseDelay;

    private long lastChanged;
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
    public void handleTouch(Vector2 touch) {
        Tile tile;
        if(active && !special){
            tile = new ActivePointTile(pos, camera);
            this.deactivate();
        }
        else if(active && special){
            tile = new MultTile(pos, camera);
            this.deactivate();
            this.setSpecial(false);
        }
        else if(!active && special){
            tile = new KillTile(pos, camera);
        }
        else{
            tile = new InactivePointTile(pos, camera);
        }
        tile.handleTouch(touch);
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
    public boolean lifeOver() {
        return (System.currentTimeMillis() - lastChanged >= delay);
    }
    public boolean isSpecial() {
        return special;
    }
    public void setSpecial(boolean special) {
        delay = 1000;
        lastChanged = System.currentTimeMillis();
        this.special = special;
    }

    public void render(SpriteBatch sb){
        if(System.currentTimeMillis() - lastChanged >= baseDelay) {
            if(active && !special) {
                if (ScoreManager.safe())
                    ScoreManager.resetMultiplier();
                else
                    ScreenManager.setScreen(new MenuScreen());
            }
            special = false;
            active = false;
        }
        this.update();
        sb.draw(texture, pos.x, pos.y);

    }

    public boolean isActive() {
        return active;
    }
    public void activate(){
        lastChanged = System.currentTimeMillis();
        delay = 1200;
        active = true;
    }
    public void deactivate(){

        delay = baseDelay;
        active = false;
    }

}
