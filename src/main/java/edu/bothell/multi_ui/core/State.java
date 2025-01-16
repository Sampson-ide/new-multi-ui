package edu.bothell.multi_ui.core;

import java.util.Arrays;

public class State implements Statable<int[]> {
    //s:btw this program is a fork, all comments with s: means they are new
    //s:IDK why the hell this happens, but whenever I move the size of S on the x or y to below 11, it doesn't run correctly. FIGURE THIS OUT!!!!
    //s:must get it down to 3 by 3 for tic tac toe
    public final char[][]   S = new char[3][3];
    /*[][]//[64][96];
    {
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '}
    };/**/

    public State(){
        System.out.println("CREATING THE STATE...");
        for(char[] row: S)
            for(int x = 0; x < row.length; x++)
                row[x] = ' ';
    }


    public void setIt(char it, int x, int y){
        this.S[y][x] = it;
        System.out.println(Arrays.deepToString(S));
    } 

    public char getIt(int x, int y){
        return S[y][x];
    }

    public char[][] getIt(){
        return S;
    }
    
    

    @Override
    public Object getIt(int[] pos){
        return S[pos[1]][pos[0]];
    }

    @Override
    public boolean isOpen(int[] pos){
        return S[pos[1]][pos[0]] == ' ';
    }

    @Override
    public int[] getAdj(int x, int y, Directions d) {
        return new int[]{x + d.dX(), y + d.dY() };
    }
    
}

