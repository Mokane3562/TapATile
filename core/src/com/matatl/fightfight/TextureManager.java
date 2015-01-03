package com.matatl.fightfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Philip on 1/3/2015.
 */
public class TextureManager {
    public final static Texture POINT_TILE = new Texture(Gdx.files.internal("pointblock.png"));
    public final static Texture MULT_TILE = new Texture(Gdx.files.internal("multblock.png"));
    public final static Texture KILL_TILE = new Texture(Gdx.files.internal("killblock.png"));
}
