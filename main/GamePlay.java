package main;

import java.util.concurrent.*;

public class GamePlay {
    private static int boardHeight = 5;
    private static int boardWidth = 5;
    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
        // Создаем новую игровую доску
        GameBoardIsland gameBoardIsland = new GameBoardIsland();
        IslandLocationCell[][] islandLocationCells = gameBoardIsland.createGameBoard(boardHeight,boardWidth);
        // Создалим executorService
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        // Добавим задание для периодического роста ростений
        executorService.scheduleAtFixedRate(new TaskGrowPlans(islandLocationCells),0, 3, TimeUnit.SECONDS);
        // Добавим задание для вывода статистики острова
        executorService.scheduleAtFixedRate(new TaskPrintStatistic(islandLocationCells),0, 5, TimeUnit.SECONDS);
        //Добавим задание для периодического перемещения Животных между локациями
        executorService.scheduleAtFixedRate(new TaskToMoveAnimal(islandLocationCells, boardHeight, boardWidth),0, 7, TimeUnit.SECONDS);
        //Задача покушать
        executorService.scheduleAtFixedRate(new TaskOfEating(islandLocationCells),0, 11, TimeUnit.SECONDS);


    }

}

