package main;

import java.util.Scanner;
import java.util.concurrent.*;

public class GamePlay {
    private static int boardHeight = 5;
    private static int boardWidth = 5;
    public static volatile IslandLocationCell[][] islandLocationCells;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // Создаем новую игровую доску
        GameBoardIsland gameBoardIsland = new GameBoardIsland();
        islandLocationCells = gameBoardIsland.createGameBoard(boardHeight,boardWidth);
        // Создалим executorService
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        // Добавим задание для периодического роста ростений
        executorService.scheduleAtFixedRate(new TaskGrowPlans(islandLocationCells),0, 3, TimeUnit.SECONDS);
        // Добавим задание для вывода статистики острова
       //executorService.scheduleAtFixedRate(new TaskReproduction(islandLocationCells),0, 1, TimeUnit.SECONDS);
        //Добавим задание для периодического перемещения Животных между локациями
        executorService.scheduleAtFixedRate(new NextStepGame(islandLocationCells, boardHeight, boardWidth),0, 6, TimeUnit.SECONDS);
        //Задача покушать
        //executorService.scheduleAtFixedRate(new TaskOfEating(islandLocationCells),0, 2, TimeUnit.SECONDS);
        while (!Thread.currentThread().isInterrupted()){
          String s = scanner.nextLine();
          if (!s.isEmpty()){
              executorService.shutdownNow();
              Thread.currentThread().interrupt();
          }


        }

    }

}

