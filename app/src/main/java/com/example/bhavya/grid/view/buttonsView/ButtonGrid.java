package com.example.bhavya.grid.view.buttonsView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.bhavya.grid.R;

/**
 * Created by Bhavya on 2/22/2017.
 */

public class ButtonGrid extends GridView{


        public ButtonGrid(Context context, AttributeSet attrs){
            super(context, attrs);

            ButtonGridAdapter gridAdapter= new ButtonGridAdapter(context);
            setAdapter(gridAdapter);
        }

        class ButtonGridAdapter extends BaseAdapter{

            private Context context;

            public ButtonGridAdapter(Context context){

                this.context= context;
            }

            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v= convertView;
                if(v==null){
                    LayoutInflater inflater= ((Activity) context).getLayoutInflater();
                    v=inflater.inflate(R.layout.button, parent, false);

                    NumbersButton btn;
                    btn= (NumbersButton)v;
                    btn.setTextSize(10);
                    btn.setBackgroundColor(Color.BLUE);
                    btn.setId(position);

                    if(position!=9){
                        btn.setText(String.valueOf(position+1));
                        btn.setNum(position + 1);
                    }else{
                        btn.setText("D");//Delete Button
                        btn.setNum(0);
                    }

                    return btn;
                }
                return v;
            }
        }
}
