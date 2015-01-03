package com.matatl.fightfight.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.matatl.fightfight.MainGame;
import com.matatl.fightfight.transition.Transition;

/**
 * Created by Philip on 1/3/2015.
 */
public class TransitionScreen extends Screen {

    Screen current;
    Screen next;
    Transition transition;

    public void create() {
        current.create();
        current.update();
    }
    public void update() {
        current.update();
    }
    public void resize(int width, int height) {
        current.resize(width, height);
    }
    public TransitionScreen(Screen current, Screen next, Transition transition) {
        this.current = current;
        this.next = next;
        this.transition = transition;
    }
    public void render(SpriteBatch sb) {
        if(transition.isFinished()) {
            ScreenManager.setScreen(next);
            return;
        }
        transition.update(Gdx.graphics.getDeltaTime());
        transition.render(sb,current,next);
        current.render(sb);
    }
    public void dispose() {

    }
    public void pause() {

    }
    public void resume() {

    }
}
