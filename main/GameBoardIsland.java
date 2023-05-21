package main;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameBoardIsland {
    private int x;
    private int y;
    CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> gameBoardIslandArray;
    //private volatile  IslandLocationCell[][] gameBoardIslandArray;



    public CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>>createGameBoard(int m, int n){
         gameBoardIslandArray = new CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>>();

        for (int i = 0; i < m; i++) {
            gameBoardIslandArray.add(new CopyOnWriteArrayList<IslandLocationCell>());
            for (int j = 0; j < n; j++) {
                this.x=i;
                this.y=j;
                gameBoardIslandArray.get(i).add(j, new IslandLocationCell(this.x,this.y));
                }
            }

        return gameBoardIslandArray;
    }

}
