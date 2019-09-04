package com.example.alex.squaregrid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class CellManager implements Cell{

    private int state;
    /*private int cellWidth;
    private int cellHeight;
    private int cellWidthInner;
    private int cellHeightInner;*/
    //private int cellBorderWidth;
    //private int cellBorderHeight;
    private int column;
    private int row;
    private Rect surfaceCell;
    private Paint surfaceCellColor;
    private Rect innerCell;
    private Paint innerCellColor;

    private Animation boxState;

    public Rect getRectangle() {
        return innerCell;
    }

    public void incrementState() {
        boxState.update();
        if (state == 3) state = 0;
        else state++;
        updateColor();
    }

    public CellManager(Bitmap[] boxStates, int state, int startX, int startY, int cellWidth, int cellHeight, int cellWidthInner, int cellHeightInner, int column, int row) {
        this.state = state;
        /*this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cellWidthInner = cellWidthInner;
        this.cellHeightInner = cellHeightInner;*/
        this.column = column;
        this.row = row;
        int cellBorderWidth = (cellWidth - cellWidthInner)/2;
        int cellBorderHeight = (cellHeight - cellHeightInner)/2;


        surfaceCell = new Rect (
                startX,
                startY,
                startX + cellWidth,
                startY + cellHeight);
        surfaceCellColor = new Paint();
        surfaceCellColor.setColor(Color.GREEN);


        innerCell = new Rect(
                startX + cellBorderWidth,
                startY + cellBorderHeight,
                startX + cellWidthInner + cellBorderWidth,
                startY + cellHeightInner + cellBorderHeight);
        innerCellColor = new Paint();
        updateColor();

        boxState = new Animation(boxStates, state);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }


    public void draw(Canvas canvas){
        canvas.drawRect(surfaceCell, surfaceCellColor);
        canvas.drawRect(innerCell, innerCellColor);
        boxState.draw(canvas, innerCell);
    }

    public void updateColor() {
        switch (state) {
            case 0:
                innerCellColor.setColor(Color.BLACK);
                break;
            case 1:
                innerCellColor.setColor(Color.BLUE);
                break;
            case 2:
                innerCellColor.setColor(Color.RED);
                break;
            case 3:
                innerCellColor.setColor(Color.MAGENTA);
                break;

        }
    }

    public void update() {

    }
}
