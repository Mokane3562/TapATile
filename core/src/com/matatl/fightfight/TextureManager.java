package com.matatl.fightfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Philip on 1/3/2015.
 */
public class TextureManager {
    public static Texture POINT_TILE = new Texture(Gdx.files.internal("pointblock.png"));
    public static Texture MULT_TILE = new Texture(Gdx.files.internal("multblock.png"));
    public static Texture KILL_TILE = new Texture(Gdx.files.internal("killblock.png"));
}
