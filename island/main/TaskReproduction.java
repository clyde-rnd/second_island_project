package island.main;

import island.GamePlay;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskReproduction implements Runnable{
    private GameBoardIsland gameBoardIsland;

    public TaskReproduction(GameBoardIsland gameBoardIsland) {
        this.gameBoardIsland = gameBoardIsland;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now() + " TaskReproduction  Started");
            gameBoardIsland.reproduction();
            System.out.println(LocalDateTime.now() + " TaskReproduction  Stop");

        }
    }


}
