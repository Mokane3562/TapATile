package com.matatl.fightfight.transition;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.matatl.fightfight.screen.Screen;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Philip on 1/3/2015.
 */
public class TimedTransition extends Transition {
    Color color=new Color();
    private ShapeRenderer shapeRenderer=new ShapeRenderer();
    public TimedTransition(float duration) {
        super(duration);
    }
    public float getAlpha() {
        return (timeLeft / duration);
    }
    public void render(SpriteBatch sb,Screen current, Screen next) {
        color.set(new Color(0,0,0,getAlpha()));
        shapeRenderer.setProjectionMatrix(sb.getProjectionMatrix());
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.end();
        current.render(sb);

    }
}
