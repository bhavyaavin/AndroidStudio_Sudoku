package com.example.bhavya.grid.view.sudokugrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.bhavya.grid.GameEngine;
/*import com.example.bhavya.grid.com.example.bhavya.grid.view.SudokuGridViewAdapter;*/

/**
 * Created by Bhavya on 2/13/2017.
 */

public class SudokuGridView extends GridView {
    private Context context;
    private int widthMeasureSpec;
    private int heightMeasureSpec;

    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context=context;

        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
        setAdapter(gridViewAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;

                GameEngine.getInstance().setSelectedPosition(x,y);
            }
        });


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    class SudokuGridViewAdapter extends BaseAdapter {

        private Context context;

        public SudokuGridViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            return GameEngine.getInstance().getGrid().getItem(position);
        }
    }
}
