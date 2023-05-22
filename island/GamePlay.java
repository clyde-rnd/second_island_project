package island;

import island.main.GameBoardIsland;
import island.main.IslandLocationCell;
import island.main.NextStepGame;
import island.main.TaskGrowPlans;

import java.util.Scanner;
import java.util.concurrent.*;

public class GamePlay {
    private static int boardHeight = 5;
    private static int boardWidth = 5;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // Создаем новую игровую доску

            GameBoardIsland gameBoardIsland = new GameBoardIsland();
            gameBoardIsland.createGameBoard(boardHeight, boardWidth);
            // Создалим executorService
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
            // Добавим задание для периодического роста ростений
            executorService.scheduleAtFixedRate(new TaskGrowPlans(gameBoardIsland), 0, 3, TimeUnit.SECONDS);
            // Добавим задание для запуска основного цикла игры
            executorService.scheduleAtFixedRate(new NextStepGame(gameBoardIsland ), 0, 5, TimeUnit.SECONDS);


        while (!Thread.currentThread().isInterrupted()) {

            String s = scanner.nextLine();
            if (!s.isEmpty()) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }

        }

    }

}

