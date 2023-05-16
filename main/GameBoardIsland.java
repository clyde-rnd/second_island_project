package main;

public class GameBoardIsland {
    private int x;
    private int y;
    private IslandLocationCell[][] gameBoardIslandArray;


    public IslandLocationCell [][] createGameBoard(int m, int n){
         gameBoardIslandArray = new IslandLocationCell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.x=i;
                this.y=j;
                gameBoardIslandArray[i][j] = new IslandLocationCell(this.x,this.y);
                }
            }

        return gameBoardIslandArray;
    }

}
