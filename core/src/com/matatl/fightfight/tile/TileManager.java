package com.matatl.fightfight.tile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.screen.GameScreen;

/**
 * Created by Philip on 1/3/2015.
 */
public class TileManager {
    private Array<Tile> tiles = new Array<Tile>();
    private Long lastTime;
    private boolean pickedActive;
    private boolean pickingActive;
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
    }
    public void update() {
        for(Tile t : tiles) {
            t.update();
        }
    }
    public void render(SpriteBatch sb) {
        float numberOfPointTiles = 9f;
        int count = 1;
        float delay = 60000/(GameScreen.bpm);
        delay = (Math.abs(GameScreen.bpm-120) <= Math.abs(GameScreen.bpm/2 - 120)) ? delay : delay * 2;
        if(System.currentTimeMillis() - lastTime > delay) {
            pickedActive = false;
            pickingActive = true;
            lastTime = System.currentTimeMillis();
        }
        for(Tile t : tiles) {
            System.out.println(count);
            if( t instanceof PointTile){
                float r = MathUtils.random(0, 100);
                r = r/100f;
                System.out.println(r + " " + 1f/numberOfPointTiles + " " + numberOfPointTiles);
                if(!pickedActive && r < 1f/numberOfPointTiles) {
                    ((PointTile) t).activate();
                    pickedActive = true;
                }
                else if(pickingActive)
                    ((PointTile) t).deactivate();
                numberOfPointTiles = numberOfPointTiles - 1f;
            }
            t.render(sb);
            count++;
        }
        pickingActive = false;
    }
    private void addTile(Tile tile) {
        tiles.add(tile);
    }
    private Array<Tile> getTiles() {
        return tiles;
    }
}
