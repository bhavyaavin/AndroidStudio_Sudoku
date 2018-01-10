package com.example.bhavya.grid;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bhavya on 2/13/2017.
 */
public class SudokuGenerator {
    private static SudokuGenerator instance;
    private ArrayList<ArrayList<Integer>>Available=new ArrayList<ArrayList<Integer>>();
    private Random rand=new Random();


    private SudokuGenerator(){


    }

    public static SudokuGenerator getInstance(){
        if(instance==null){
            instance=new SudokuGenerator();
        }
        return instance;
    }

    public int[][] Grid(){
        int[][] Sudoku = new int[9][9];
        int presentPosition=0;

        clearGrid(Sudoku);

        while (presentPosition<81){
            if (Available.get(presentPosition).size()!=0){
                int i=rand.nextInt(Available.get(presentPosition).size());
                int num= Available.get(presentPosition).get(i);

                if (!conflictchk(Sudoku, presentPosition, num)){
                    int xPosition = presentPosition % 9;
                    int yPosition = presentPosition / 9;

                    Sudoku[xPosition][yPosition]=num;

                    Available.get(presentPosition).remove(i);

                    presentPosition++;
                }else{
                    Available.get(presentPosition).remove(i);
                }

            }else{
                for (int i=1;i<=9;i++){
                    Available.get(presentPosition).add(i);
                }
                presentPosition--;
            }


        }
        return Sudoku;
    }

    public int[][] removeElements(int[][] Sudoku){

        int k=0;

        while(k<35){
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);

            if (Sudoku[i][j]!=0){
                Sudoku[i][j] = 0;
                k++;

            }
        }
        return Sudoku;
    }
    private void clearGrid(int[][] Sudoku){
        Available.clear();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                Sudoku[i][j]=-1;
            }
        }
        for(int i=0;i<81;i++){
            Available.add(new ArrayList<Integer>());
            for(int j=1;j<=9;j++){
                Available.get(i).add(j);
            }
        }
    }
    private boolean conflictchk(int[][] Sudoku, int presentPosition, final int num){
        int xPosition = presentPosition % 9;
        int yPosition = presentPosition / 9;



        if (horizontalConflictchk(Sudoku, xPosition, yPosition, num)||verticalConflictchk(Sudoku, xPosition, yPosition,num)||regionConflictchk(Sudoku, xPosition, yPosition, num)){
            return true;
        }
        return false;

    }
    /* Returns true if there is any conflict*/
    private boolean horizontalConflictchk(final int[][] Sudoku, final int xPosition, final int yPosition, final int num){

        for(int i = xPosition-1; i>=0; i-- ) {
            if (num == Sudoku[i][yPosition]) {
                return true;
            }
        }
        return false;
    }

    private boolean verticalConflictchk(final int[][] Sudoku, final int xPosition, final int yPosition, final int num){
        for (int j = yPosition-1; j>=0;j--){
            if (num == Sudoku[xPosition][j]){

                return true;
            }
        }
        return false;
    }
    private boolean regionConflictchk(final int[][] Sudoku, final int xPosition, final int yPosition, final int num){
        int xRegion = xPosition / 3;
        int yRegion = yPosition / 3;
        for (int x=xRegion * 3; x< xRegion * 3 + 3; x++){
            for(int y=yRegion * 3; y< yRegion * 3 + 3; y++){
                if((x != xPosition || y != yPosition)&& num == Sudoku[x][y]){
                    return true;
                }
            }
        }

        return false;
    }
}