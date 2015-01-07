package com.matatl.fightfight.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

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
    public static final Animation GAME_BACKGROUND = com.holidaystudios.tools.GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("stars.gif").read());
    public static final Texture GAME_BACKGROUND_MAGIC = new Texture(Gdx.files.internal("stars.gif"));
}
