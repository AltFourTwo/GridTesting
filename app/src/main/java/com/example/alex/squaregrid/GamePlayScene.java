package com.example.alex.squaregrid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.Button;

public class GamePlayScene implements Scene {

    private Rect r = new Rect();
    private Button menuBtn;

    private GridManager gridManager;

    public GamePlayScene() {
        gridManager = new GridManager(new Rect(0,0,Constants.SCREEN_WIDTH - 200, Constants.SCREEN_HEIGHT), 96,96, 64,64, 32);
        //menuBtn = new Button(1,2,3,4)
    }

    public void reset() {
        //gridManager = new GridManager();
    }

    @Override
    public void terminate() {
        //manager.setScene(0);
        //SceneManager.ACTIVE_SCENE = 0;
    }

    public void receiveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                gridManager.receiveTouch(event);
                break;
            case MotionEvent.ACTION_MOVE:
                //event.
        }
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        gridManager.draw(canvas);
    }

    public void update() {

    }

    // andreas1724 (white color):
    private void drawCenterText(Canvas canvas, Paint paint, String text) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);
    }

}