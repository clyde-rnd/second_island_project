package main;

public class main {
    public static void main(String[] args) {
        GameBoardIsland gameBoardIsland = new GameBoardIsland();
       IslandLocationCell[][] islandLocationCells = gameBoardIsland.createGameBoard(3,3);
        for (int i = 0; i < islandLocationCells[0][0].islandHerbivores.size(); i++) {
            System.out.println(islandLocationCells[0][0].islandHerbivores.get(i).getEmoji());
        }

    }
}
