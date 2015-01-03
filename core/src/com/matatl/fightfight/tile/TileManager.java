package com.matatl.fightfight.tile;
import com.badlogic.gdx.Gdx;
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
    private static final float SPEC_CHANCE = 0.005f;
    private static final float BOMB_CHANCE = 0.5f;
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
        pickingActive = true;
        if(Math.random() < SPEC_CHANCE) {
            int sel = ((int) (Math.random() * 9));
            ((PointTile) tiles.get(sel)).setSpecial(true);
            if (Math.random() < BOMB_CHANCE) {
                ((PointTile) tiles.get(sel)).deactivate();
            }
            else {
                ((PointTile) tiles.get(sel)).activate();
            }
        }
        for(Tile t : tiles) {
            if( ((PointTile) t).isActive()) {
                pickingActive = false;
            }
        }
        if(pickingActive) {
            PointTile pt = ((PointTile)tiles.get((int)(Math.random()*9)));
            while(pt.isSpecial()) {
                pt = ((PointTile)tiles.get((int)(Math.random()*9)));
            }
            pt.activate();
        }
        for(Tile t : tiles) {
            ((PointTile)t).render(sb, Gdx.graphics.getDeltaTime());
        }


    }
    private void addTile(Tile tile) {
        tiles.add(tile);
    }
    private Array<Tile> getTiles() {
        return tiles;
    }
}
