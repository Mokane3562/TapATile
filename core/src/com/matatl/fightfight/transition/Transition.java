package com.matatl.fightfight.transition;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matatl.fightfight.screen.Screen;

/**
 * Created by Philip on 1/3/2015.
 */
public abstract class Transition {
    protected float duration;
    protected float timeLeft;
    public Transition(float duration) {
        this.duration = duration;
        this.timeLeft = duration;
    }
    public void update(float delta) {
        timeLeft -= delta;
    }

    public abstract void render(SpriteBatch sb,Screen current, Screen next);

    public boolean isFinished() {
        return timeLeft <= 0;
    }
}
