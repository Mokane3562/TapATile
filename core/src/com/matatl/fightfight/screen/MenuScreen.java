package com.matatl.fightfight.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Mokane on 1/3/2015.
 */
public class MenuScreen extends Screen {
    private OrthoCamera camera;

    @Override
    public void create() {
        camera = new OrthoCamera();
        System.out.println("MenuScreen created");
    }

    @Override
    public void update() {
        camera.update();
        System.out.println("MenuScreen updated");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
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
