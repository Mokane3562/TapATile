package com.matatl.fightfight.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.MainGame;
import com.matatl.fightfight.ScoreManager;
import com.matatl.fightfight.TextureManager;
import com.matatl.fightfight.camera.OrthoCamera;
import com.matatl.fightfight.tile.Tile;
import com.matatl.fightfight.tile.TileManager;

public class GameScreen extends Screen {
    private OrthoCamera camera;
    public static Music backtrack;
    public static int bpm=184;
    private TileManager tileManager;
    private ScoreManager scoreManager;
    private int score;
    private boolean isLost;
    private long lastClick;
    @Override
    public void create() {
        bpm = 184;
        camera = new OrthoCamera();
        camera.resize();
        score = 0;
        tileManager = new TileManager(camera);
        scoreManager = new ScoreManager(camera);
        backtrack = Gdx.audio.newMusic(Gdx.files.internal("9 - Future Sick.mp3"));
        lastClick = System.currentTimeMillis();
        backtrack.play();
    }
    @Override
    public void update() {
        camera.update();
        tileManager.update();
        if(Gdx.input.isTouched()){
            if(System.currentTimeMillis()-lastClick >= 200) {
                lastClick = System.currentTimeMillis();
                Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
                tileManager.handleTouch(touch);
            }
        }
        camera.resize();
    }
    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(TextureManager.GAME_BACKGROUND, 0, MainGame.HEIGHT / 2 - TextureManager.GAME_BACKGROUND.getHeight() / 2);
        tileManager.render(spriteBatch);
        scoreManager.render(spriteBatch,score);
        spriteBatch.end();
    }
    @Override
    public void resize(int width, int height) {
        camera.resize();
    }
    @Override
    public void dispose() {
        backtrack.dispose();
    }
    @Override
    public void pause() {
        backtrack.pause();
    }
    @Override
    public void resume() {
        backtrack.play();
    }
    public boolean isLost(){
        return isLost;
    }
}
