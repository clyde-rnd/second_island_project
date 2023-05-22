package island.main;

import island.GamePlay;
import island.plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskOfEating implements Runnable{
    private GameBoardIsland gameBoardIsland;

    public TaskOfEating(GameBoardIsland gameBoardIsland) {
        this.gameBoardIsland = gameBoardIsland;
    }

    @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println(LocalDateTime.now() + " TaskOfEating Started");
                gameBoardIsland.eating();
                System.out.println(LocalDateTime.now() + " TaskOfEating Stop");

            }

            }
}
