package com.matatl.fightfight.tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;

import java.awt.Point;

/**
 * Created by Philip on 1/3/2015.
 */
public class TileManager {
    private Array<PointTile> tiles = new Array<PointTile>();
    private Long lastTime;
    private static final float SPEC_CHANCE = 0.005f;
    private static final float BOMB_CHANCE = 0.5f;
    private boolean pickedActive;
    private boolean pickingActive;
    private float baseDelay =60000/(GameScreen.bpm);

    public TileManager(OrthoCamera camera) {
        addTile(new PointTile(new Vector2(10,160),camera));
        addTile(new PointTile(new Vector2(180,160),camera));
        addTile(new PointTile(new Vector2(350,160),camera));
        addTile(new PointTile(new Vector2(10,320),camera));
        addTile(new PointTile(new Vector2(180,320),camera));
        addTile(new PointTile(new Vector2(350,320),camera));
        addTile(new PointTile(new Vector2(10,480),camera));
        addTile(new PointTile(new Vector2(180,480),camera));
        addTile(new PointTile(new Vector2(350, 480), camera));
        lastTime = System.currentTimeMillis();
        pickedActive = true;
        pickingActive = false;
        baseDelay = (Math.abs(GameScreen.bpm-120) <= Math.abs(GameScreen.bpm/2 - 120)) ? baseDelay : baseDelay * 2;
    }
    public void update() {
        for(PointTile t : tiles) {
            t.update();
        }
    }
    public void render(SpriteBatch sb) {
        pickingActive = true;
        if(Math.random() < SPEC_CHANCE) {
            int sel = ((int) (Math.random() * 9));
            (tiles.get(sel)).setSpecial(true);
            if (Math.random() < BOMB_CHANCE) {
                ( tiles.get(sel)).deactivate();
            }
            else {
                (tiles.get(sel)).activate();
            }
        }
        pickingActive = (System.currentTimeMillis() - lastTime >= baseDelay);
        for(PointTile t : tiles) {
            if( t.isActive() && !t.isSpecial()) {
                pickingActive = false;
            }
        }
        if(pickingActive) {
            PointTile pt = (tiles.get((int)(Math.random()*9)));
            while(pt.isSpecial()) {
                pt = (tiles.get((int)(Math.random()*9)));
            }
            lastTime = System.currentTimeMillis();
            pt.activate();
        }
        for(PointTile t : tiles) {
            (t).render(sb);
        }


    }
    private void addTile(PointTile tile) {
        tiles.add(tile);
    }
    private Array<PointTile> getTiles() {
        return tiles;
    }
    public void handleTouch(Vector2 touch){
        for(Tile t : tiles){
            t.handleTouch(touch);
        }
    }
}
