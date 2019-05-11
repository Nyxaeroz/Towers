package com.ThijsProjects.towers;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.service.quicksettings.Tile;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;

public class GameView extends View {

    private final int SIZE;
    private final int BOARD_WIDTH;
    private final int TILE_SIZE;
    private int margin;

    private ArrayList<RectangleWithInt> board = new ArrayList<>();


    public GameView(Context context, int size){
        super(context);

        this.SIZE = size;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        BOARD_WIDTH = (int) (displayMetrics.widthPixels * 0.8);
        margin = (int) (displayMetrics.widthPixels * 0.1);
        TILE_SIZE = BOARD_WIDTH / SIZE;
    }

    //Draws the board
    @Override
    public void onDraw(Canvas c){
        super.onDraw(c);

        Paint outline = new Paint();
        Paint filling = new Paint();

        if(board.isEmpty()) {
            for (int x = 0; x < this.SIZE; x++) {
                for (int y = 0; y < this.SIZE; y++) {
                    Rect r = new Rect(margin + x * TILE_SIZE, margin + y * TILE_SIZE, margin + (x + 1) * TILE_SIZE, margin + (y + 1) * TILE_SIZE);
                    this.board.add(new RectangleWithInt(0, r));
                    filling.setColor(fetchColorByInt(0));
                    c.drawRect(r, filling);
                }
            }
        } else {
            for (int i = 0; i < this.board.size(); i++) {
                filling.setColor(fetchColorByInt(board.get(i).getValue()));
                filling.setStyle(Paint.Style.FILL);
                c.drawRect(board.get(i).getRectangle(), filling);
            }
        }

        outline.setColor(fetchPrimaryDarkColor());
        outline.setStrokeWidth(3);
        outline.setStyle(Paint.Style.STROKE);
        c.drawRect(new Rect(margin, margin, margin+ BOARD_WIDTH, margin + BOARD_WIDTH), outline);
    }

    //Detects MotionEvents
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            int touchX = (int) event.getX();
            int touchY = (int) event.getY();
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
//                    System.out.println("Touching down!");
                    for(int i = 0; i < board.size(); i++){
                        if(board.get(i).getRectangle().contains(touchX,touchY)){
//                            System.out.println("Touched Rectangle.");
                            board.get(i).setValue((board.get(i).getValue() + 1) % (SIZE + 1));
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
//                    System.out.println("Touching up!");
                    break;
                case MotionEvent.ACTION_MOVE:
//                    System.out.println("Sliding your finger around on the screen.");
                    break;
            }
            return true;
        } catch(Exception e){
            return true;
        }
    }

    //fetches the accent color of the application
    private int fetchAccentColor() {
        TypedValue typedValue = new TypedValue();
        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    //fetches the primary color of the application
    private int fetchPrimaryColor() {
        TypedValue typedValue = new TypedValue();
        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimary });
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    //fetches the primary color (dark) of the application
    private int fetchPrimaryDarkColor() {
        TypedValue typedValue = new TypedValue();
        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorPrimaryDark });
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    //fetches tower color by value
    private int fetchColorByInt(int v) {
        switch (v){
            case 0:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor0);
            case 1:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor1);
            case 2:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor2);
            case 3:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor3);
            case 4:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor4);
            case 5:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor5);
            case 6:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor6);
            case 7:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor7);
            case 8:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor8);
            case 9:
                return ContextCompat.getColor(this.getContext(), R.color.towerColor9);
            default:
                return ContextCompat.getColor(this.getContext(), R.color.colorAccent);
        }
    }

}
