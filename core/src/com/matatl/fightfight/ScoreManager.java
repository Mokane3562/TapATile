package com.matatl.fightfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Philip on 1/3/2015.
 */
public class ScoreManager {
    private int hiScore;

    private Preferences prefs = Gdx.app.getPreferences("FFPreferences");
    private final static String HI_SCORE_KEY = "ff_hiScore";
    OrthoCamera camera;
    public ScoreManager(OrthoCamera camera) {
        this.camera = camera;
        this.hiScore = prefs.getInteger(HI_SCORE_KEY);
    }
    public void render(SpriteBatch sb, int score) {
        hiScore = prefs.getInteger(HI_SCORE_KEY);
        if( score > hiScore ) {
            prefs.putInteger(HI_SCORE_KEY, score);
            prefs.flush();
        }
    }
}
