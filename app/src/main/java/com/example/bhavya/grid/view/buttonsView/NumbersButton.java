package com.example.bhavya.grid.view.buttonsView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.bhavya.grid.GameEngine;

/**
 * Created by Bhavya on 2/22/2017.
 */

public class NumbersButton extends Button implements View.OnClickListener {

    private int num;
    public NumbersButton(Context context, AttributeSet attrs){
        super(context, attrs);
        setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        GameEngine.getInstance().setNum(num);

    }

    public void setNum(int num){
        this.num = num;
    }

    public void setBackgroundColor( int Color) {

    }
}
