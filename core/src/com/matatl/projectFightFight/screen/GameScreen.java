package com.matatl.projectFightFight.screen;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.projectFightFight.camera.OrthoCamera;

public class GameScreen extends Screen {
    private OrthoCamera camera;
    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
    }
    @Override
    public void update() {
        camera.update();
        camera.resize();
    }
    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.end();
    }
    @Override
    public void resize(int width, int height) {
        camera.resize();
    }
    @Override
    public void dispose() {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
}
