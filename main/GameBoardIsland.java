package main;

import herbivores.*;
import plants.Plants;
import predator.*;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardIsland {
    private int x;
    private int y;


    public IslandLocationCell [][] createGameBoard(int m, int n){
        IslandLocationCell[][] GameBoardIslandArray = new IslandLocationCell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.x=i;
                this.y=j;
                GameBoardIslandArray[i][j] = new IslandLocationCell(this.x,this.y);
                }
            }

        return GameBoardIslandArray;
    }

}
