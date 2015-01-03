package com.matatl.fightfight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Mokane on 1/3/2015.
 */
public class MenuScreen extends Screen {
    private OrthoCamera camera;
    private Rectangle playRectangle;

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        playRectangle = new Rectangle(171, 462, 115, 32);
        System.out.println("MenuScreen created");
    }

    @Override
    public void update() {
        camera.update();
        if (playRectangle.contains(Gdx.input.getX(), Gdx.input.getY()) && Gdx.input.isTouched()) {
            ScreenManager.setScreen(new GameScreen());
        }
        System.out.println("MenuScreen updated");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(TextureManager.MENU_SCREEN,0,0);
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
