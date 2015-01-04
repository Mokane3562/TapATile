package com.matatl.fightfight.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.AudioManager;
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
    public float frameCounter = 0;
    private TileManager tileManager;
    private ScoreManager scoreManager;
    private boolean isLost;
    private long lastClick;
    private Preferences prefs = Gdx.app.getPreferences("FFPreferences");
    private final static String HI_SCORE_KEY = "ff_hiScore";
    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        tileManager = new TileManager(camera);
        scoreManager = new ScoreManager(camera, prefs);
        AudioManager.initSongs();
        int r = MathUtils.random(AudioManager.songList().size-1);
        bpm = AudioManager.songList().get(r).getBPM();
        backtrack = AudioManager.songList().get(r).getMusic();
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
        frameCounter += Gdx.graphics.getDeltaTime();
        spriteBatch.draw(TextureManager.GAME_BACKGROUND.getKeyFrame(frameCounter, true),0, MainGame.HEIGHT / 2 - TextureManager.GAME_BACKGROUND_MAGIC.getHeight() / 2);
        //spriteBatch.draw(TextureManager.GAME_BACKGROUND, 0, MainGame.HEIGHT / 2 - TextureManager.GAME_BACKGROUND.getHeight() / 2);
        tileManager.render(spriteBatch);
        scoreManager.render(spriteBatch);
        BitmapFont font = new BitmapFont();
        font.setColor(1, 1, 1, 1);
        font.setScale(3, 3);
        font.draw(spriteBatch, "Score: " + scoreManager.getScore(), 40, 700);
        font.draw(spriteBatch, "" + scoreManager.getMultiplier() + "X", 350, 700);
        font.draw(spriteBatch, "High Score: " + scoreManager.getHiScore(), 40, 100);
        scoreManager.setHiScore(prefs.getInteger(HI_SCORE_KEY));
        if( scoreManager.getScore() > scoreManager.getHiScore() ) {
            prefs.putInteger(HI_SCORE_KEY, scoreManager.getScore());
            prefs.flush();
        }
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