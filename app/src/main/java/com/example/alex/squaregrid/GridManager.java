package com.example.alex.squaregrid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public class GridManager implements Grid {
    private ArrayList<CellManager> cells = new ArrayList<>();


    private Rect gridArea;
    private int columns;
    private int rows;
    private int borderWidth;
    private int borderFull;
    private int cellWidth;
    private int cellHeight;
    private int cellWidthInner;
    private int cellHeightInner;
    //private int cellType;
    //private int[] cellTypes;

    public GridManager(Rect gridArea, int cellWidth, int cellHeight, int cellWidthInner, int cellHeightInner, int borderWidth) {
        this.gridArea = gridArea;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cellWidthInner = cellWidthInner;
        this.cellHeightInner = cellHeightInner;
        this.borderWidth = borderWidth;

        columns = (gridArea.width() - borderFull)/cellWidth;
        rows = (gridArea.height() - borderFull)/cellHeight;

        borderFull = borderWidth*2;
        populateGrid();
    }

    public void populateGrid() {

        BitmapFactory bf = new BitmapFactory();
        Bitmap boxBlack = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.box_black);
        //boxBlack.setHasAlpha(true);
        Bitmap boxBlue = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.box_blue);
        //boxBlue.setHasAlpha(true);
        Bitmap boxRed = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.box_red);
        //boxRed.setHasAlpha(true);
        Bitmap boxPurple = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.box_purp);
        //boxPurple.setHasAlpha(true);

        Bitmap[] boxState = {boxBlack, boxBlue, boxRed, boxPurple};

        int extraX = gridArea.width() - borderFull - cellWidth*columns;
        int extraY = gridArea.height() - borderFull - cellHeight*rows;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                cells.add(new CellManager(boxState,1,
                        borderWidth+(extraX/2)+(cellWidth*j),
                        borderWidth+(extraY/2)+(cellHeight*i),
                        cellWidth,
                        cellHeight,
                        cellWidthInner,
                        cellHeightInner,
                        j+1,
                        i+1));
            }
        }
    }

    public void receiveTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (gridArea.contains((int)event.getX(),(int)event.getY())) {
                for(CellManager cell :cells) {
                    if (cell.getRectangle().contains((int)event.getX(),(int)event.getY())) {
                        cell.incrementState();
                        System.out.println("Touched cell column "+ cell.getColumn() + " row " + cell.getRow() + "." );
                    }
                }
            }
        }
    }

    public void update() {

    }

    public void draw(Canvas canvas) {
        for(CellManager cell :cells) {
            cell.draw(canvas);
        }
    }

    public void setCellWidth(int width){
        cellWidth = width;
    }

    public void setCellHeight(int height) {
        cellHeight = height;
    }

    public void setCellWidthInner(int width) {
        cellWidthInner = width;
    }

    public  void setCellHeightInner(int height) {
        cellHeightInner = height;
    }




}
