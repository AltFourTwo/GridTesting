package com.example.alex.squaregrid;

import android.graphics.Canvas;
import android.graphics.Rect;

public class AnimationManager {
    private Animation[] animations;
    private int animationIndex = 0;

    public AnimationManager(Animation[] animations) {
        this.animations = animations;
    }

    public void draw(Canvas canvas, Rect rect) {
        animations[animationIndex].draw(canvas, rect);
    }

    public void update() {
        animations[animationIndex].update();
    }
}
