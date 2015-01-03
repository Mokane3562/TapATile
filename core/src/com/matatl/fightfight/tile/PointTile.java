package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by scott on 2015-01-03.
 */
public class PointTile extends Tile{
    private ActivePointTile activePointTile;
    private InactivePointTile inactivePointTile;
    private boolean active;
    public PointTile(Vector2 pos, OrthoCamera camera) {
        super(null, pos, camera);
        activePointTile = new ActivePointTile(pos, camera);
        inactivePointTile = new InactivePointTile(pos, camera);
        active = false;
    }

    @Override
    public void update() {

    }

    public void render(SpriteBatch sb){
        if(active)
            activePointTile.render(sb);
        else
            inactivePointTile.render(sb);
    }

    public void activate(){
        active = true;
    }
    public void deactivate(){
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
