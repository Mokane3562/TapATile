package com.matatl.fightfight.tile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class TileManager {
    private Array<Tile> tiles = new Array<Tile>();
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
    }
    public void update() {
        for(Tile t : tiles) {
            t.update();
        }
    }
    public void render(SpriteBatch sb) {
        for(Tile t : tiles) {
            t.render(sb);
        }
    }
    private void addTile(Tile tile) {
        tiles.add(tile);
    }
    private Array<Tile> getTiles() {
        return tiles;
    }
}
