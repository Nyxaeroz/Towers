package com.ThijsProjects.towers;

import android.graphics.Rect;

public class RectangleWithInt{
    private int value;
    private Rect rect;

    public RectangleWithInt(int v, Rect r){
        this.value = v;
        this.rect = r;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Rect getRectangle() {
        return rect;
    }

    public void setRectangle(Rect rectangle) {
        this.rect = rectangle;
    }
}
