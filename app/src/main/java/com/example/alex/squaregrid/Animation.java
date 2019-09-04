package com.example.alex.squaregrid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Animation {
    private Bitmap[] frames;
    private int stateIndex;

    public Animation(Bitmap[] frames, int state) {
        this.frames = frames;
        stateIndex = state;
    }

    public void draw(Canvas canvas, Rect destination) {
        canvas.drawBitmap(frames[stateIndex], null, destination, new Paint());
    }

    public void update() {
        stateIndex = stateIndex == frames.length-1 ? 0 : stateIndex +1;
    }
}
