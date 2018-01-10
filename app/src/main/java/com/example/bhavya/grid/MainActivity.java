package com.example.bhavya.grid;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameEngine.getInstance().createGrid(this);
    }
    private void printSudoku(int[][] Sudoku){
        for (int j=0; j<9; j++) {
            for(int i=0; i<9;i++){
                System.out.print(Sudoku[i][j] + "|");
            }
            System.out.println();
        }

    }
}
