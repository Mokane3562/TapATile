package com.matatl.fightfight.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.fightfight.util.OrthoCamera;

/**
 * Created by Mokane on 1/3/2015.
 *
 * A would be visualizer test screen. never used.
 */
public class VisualizerScreen extends Screen {
    private OrthoCamera camera;

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        System.out.println("MenuScreen created");
    }

    @Override
    public void update() {
        camera.update();
        System.out.println("MenuScreen updated");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        spriteBatch.end();
        System.out.println("MenuScreen rendered");
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
        System.out.println("MenuScreen resized");
    }

    @Override
    public void dispose() {
        System.out.println("MenuScreen disposed");
    }

    @Override
    public void pause() {
        System.out.println("MenuScreen paused");
    }

    @Override
    public void resume() {
        System.out.println("MenuScreen resumed");
    }
}
