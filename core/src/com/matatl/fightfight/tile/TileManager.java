package com.matatl.fightfight.tile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class TileManager {
    private Array<Tile> tiles = new Array<Tile>();
    public TileManager(OrthoCamera camera) {
        addTile(new KillTile(new Vector2(100,100),camera));
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
