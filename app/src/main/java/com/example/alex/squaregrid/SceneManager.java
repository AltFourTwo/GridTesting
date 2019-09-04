package com.example.alex.squaregrid;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class SceneManager {
    private ArrayList<Scene> scenes = new ArrayList<>();
    private int activeScene;   // Conventionnal Way
    //public static int ACTIVE_SCENE;

    public SceneManager() {
        activeScene = 0;
        //ACTIVE_SCENE = 0;
        scenes.add(new GamePlayScene());
    }

    // Conventionnal Way
    public void setScene(int activeScene) {
        this.activeScene = activeScene;
    }


    public void receiveTouch(MotionEvent event) {
        scenes.get(activeScene).receiveTouch(event);
    }

    public void update() {
        scenes.get(activeScene).update();
    }

    public void draw(Canvas canvas) {
        scenes.get(activeScene).draw(canvas);
    }
}