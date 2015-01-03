package com.matatl.fightfight.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Tile {
    protected Texture texture;
    protected Vector2 pos;
    public Tile(Texture texture, Vector2 pos) {
        this.texture = texture;
        this.pos = pos;
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
}