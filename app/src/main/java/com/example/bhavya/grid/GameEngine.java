package com.example.bhavya.grid;

import android.content.Context;

import com.example.bhavya.grid.view.sudokugrid.SudokuGrid;

/**
 * Created by Bhavya on 2/21/2017.
 */

public class GameEngine {
    private static GameEngine instance;

    private SudokuGrid grid = null;

    private int selectedPosX= -1, selectedPosY=-1;

    private GameEngine(){}

    public static GameEngine getInstance(){
        if (instance == null ){
            instance = new GameEngine();
        }
        return instance;
    }
    public void createGrid(Context context){

        int [][] Sudoku = SudokuGenerator.getInstance().Grid();
        Sudoku= SudokuGenerator.getInstance().removeElements(Sudoku);
        grid = new SudokuGrid(context);
        grid.setGrid(Sudoku);


    }

   public SudokuGrid getGrid(){
       return grid;
   }

    public void setSelectedPosition(int x, int y){

        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNum(int num){

        if(selectedPosX !=-1 && selectedPosY !=-1){
            grid.setItem(selectedPosX,selectedPosY,num);

        }

        grid.checkSudoku();

    }
}
