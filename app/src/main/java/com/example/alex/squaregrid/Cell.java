package com.example.alex.squaregrid;

import android.graphics.Canvas;

public interface Cell {
    void draw(Canvas canvas);
    void update();
    void updateColor();
}
