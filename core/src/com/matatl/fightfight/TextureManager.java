package com.matatl.fightfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Philip on 1/3/2015.
 */
public class TextureManager {
    public static final Texture POINT_TILE = new Texture(Gdx.files.internal("pointblock.png"));
    public static final Texture MULT_TILE = new Texture(Gdx.files.internal("multblock.png"));
    public static final Texture KILL_TILE = new Texture(Gdx.files.internal("killblock.png"));
    public static final Texture MENU_SCREEN = new Texture(Gdx.files.internal("menurough.png"));
    public static final Texture LOAD_SCREEN = new Texture(Gdx.files.internal("load.png"));
    public static final Texture INACTIVE_POINT_TILE = new Texture(Gdx.files.internal("inactivepointblock.png"));
    public static final Texture PLAY_BUTTON = new Texture(Gdx.files.internal("play.png"));
    public static final Texture GAME_BACKGROUND = new Texture(Gdx.files.internal("stars.gif"));
}
