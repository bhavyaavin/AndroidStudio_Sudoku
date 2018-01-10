package com.example.bhavya.grid.view.sudokugrid;

import android.content.Context;
import android.widget.Toast;

import com.example.bhavya.grid.SudokuCheck;

/**
 * Created by Bhavya on 2/22/2017.
 */

public class SudokuGrid {

    private SudokuCellView[][] Sudoku = new SudokuCellView[9][9];
    private Context context;

    public SudokuGrid(Context context){
        this.context = context;
        for (int x=0; x<9; x++){
            for(int y=0; y<9; y++){
               Sudoku[x][y]=new SudokuCellView(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Sudoku[x][y].setInitValue(grid[x][y]);
                if(grid[x][y]!=0)
                {
                    Sudoku[x][y].setNotModifiable();
                }
            }
        }

    }

    public SudokuCellView [][] getGrid(){
        return Sudoku;

    }


    public SudokuCellView getItem(int i, int j){
        return Sudoku[i][j];
    }

    public SudokuCellView getItem(int position){
        int x = position % 9;
        int y = position / 9;

        return Sudoku[x][y];
    }

    public void setItem(int x, int y, int num) {
        Sudoku[x][y].setValue(num);
    }

    public void checkSudoku(){
        int [][] gameGrid = new int[9][9];
        for( int x=0; x<9; x++){
            for( int y=0; y<9; y++){
                gameGrid[x][y] = getItem(x,y).getValue();

            }
        }
        if(SudokuCheck.getInstance().checkGame(gameGrid)){
            Toast.makeText(context, "Sudoku is Solved", Toast.LENGTH_LONG).show();
        }
    }
}
