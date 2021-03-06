package com.matatl.fightfight.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.util.OrthoCamera;
import com.matatl.fightfight.util.TileManager;

public abstract class Tile {
    protected Texture texture;
    protected Vector2 pos;
    protected TileManager tileManager;
    protected OrthoCamera camera;
    public Tile(Texture texture, Vector2 pos, OrthoCamera camera) {
        this.texture = texture;
        this.pos = pos;
        this.camera = camera;
    }
    public abstract void update();

    public void render(SpriteBatch sb) {
        sb.draw(texture, pos.x, pos.y);
    }
    public Vector2 getPosition() {
        return pos;
    }
    public Rectangle getBounds() {
        return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }
    public boolean containsPoint(Vector2 point){
        return getBounds().contains(point.x, point.y);
    }
    public abstract void handleTouch(Vector2 touch);
}