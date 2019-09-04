package com.example.alex.squaregrid;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Grid {
    void populateGrid();
    void receiveTouch(MotionEvent event);
    void update();
    void draw(Canvas canvas);
    void setCellWidth(int width);
    void setCellHeight(int height);
    void setCellWidthInner(int width);
    void setCellHeightInner(int height);
}
