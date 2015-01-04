package com.matatl.fightfight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.matatl.fightfight.MainGame;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;

/**
 * Created by Mokane on 1/3/2015.
 */
public class MenuScreen extends Screen {
    private OrthoCamera camera;
    private Vector2 playRectPos = new Vector2(182, 462);
    private Rectangle playRectangle = new Rectangle(playRectPos.x, playRectPos.y, 115, 32);

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        System.out.println("MenuScreen created");
    }

    @Override
    public void update() {
        camera.update();

        if (Gdx.input.isTouched()){
            Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
            if (playRectangle.contains(touch)){
                ScreenManager.setScreen(new GameScreen());
            }
        }
        System.out.println("MenuScreen updated");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(TextureManager.MENU_SCREEN, 20, MainGame.HEIGHT / 2 - TextureManager.MENU_SCREEN.getHeight() / 2);
        spriteBatch.draw(TextureManager.PLAY_BUTTON, playRectPos.x+20, playRectPos.y);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
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
