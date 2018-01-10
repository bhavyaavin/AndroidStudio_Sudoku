package com.example.bhavya.grid.view.sudokugrid;

import android.content.Context;
import android.view.View;

/**
 * Created by Bhavya on 2/22/2017.
 */

public class BaseSudokuCell extends View {

    private int value;
    private boolean modifiable = true;

    public BaseSudokuCell(Context context){
        super(context);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

    }

    public void setNotModifiable(){
        modifiable =false;
    }

    public void setInitValue(int value){
        this.value = value;
        invalidate();
    }

    public void setValue(int value){
        if(modifiable) {
            this.value = value;

        }
        invalidate();
    }

    public int getValue(){
        return value;
    }
}
