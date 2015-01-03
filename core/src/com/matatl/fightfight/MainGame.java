package com.matatl.fightfight;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.fightfight.screen.GameScreen;
import com.matatl.fightfight.screen.MenuScreen;
import com.matatl.fightfight.screen.ScreenManager;

public class MainGame extends ApplicationAdapter {
	SpriteBatch spriteBatch;

	public static final int WIDTH = 480, HEIGHT = 800;
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
        ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().update();
        }
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().render(spriteBatch);
        }
	}

    @Override
    public void dispose(){
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().dispose();
        }
    }

    @Override
    public void resize(int width, int height){
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resize(width, height);
        }
    }

    @Override
    public void pause(){
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().pause();
        }
    }

    @Override
    public void resume(){
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resume();
        }
    }
}
