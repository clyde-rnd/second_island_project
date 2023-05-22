package island.main;


import island.GamePlay;
import island.plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskGrowPlans implements Runnable {
    private GameBoardIsland gameBoardIsland;

    public TaskGrowPlans(GameBoardIsland gameBoardIsland) {
        this.gameBoardIsland = gameBoardIsland;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now() + " TaskGrowPlans Started");
            gameBoardIsland.growPlans();
            System.out.println(LocalDateTime.now() + " TaskGrowPlans Stop");

        }

    }
}
