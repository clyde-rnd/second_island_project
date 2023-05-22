package island.main;

import island.GamePlay;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskToMoveAnimal implements Runnable{
    private int boardHeight;
    private int boardWidth;
    private GameBoardIsland gameBoardIsland;

    public TaskToMoveAnimal( GameBoardIsland gameBoardIsland ) {
        this.gameBoardIsland = gameBoardIsland;

    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskToMoveAnimal Started");
            gameBoardIsland.moveAnimal();
            System.out.println(LocalDateTime.now()+" TaskToMoveAnimal Stop");

            }

    }
}

