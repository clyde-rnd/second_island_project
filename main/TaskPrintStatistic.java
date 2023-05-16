package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskPrintStatistic implements Runnable{
    private IslandLocationCell[][] islandLocationCells;

    public TaskPrintStatistic(IslandLocationCell[][] islandLocationCells) {
        this.islandLocationCells = islandLocationCells;
    }
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskPrintStatistic Started");
            for (int i = 0; i < islandLocationCells.length; i++) {
                for (int j = 0; j < islandLocationCells[i].length; j++) {
                    System.out.print("Cell - " + i + "X" + j + " ");
                    for (CopyOnWriteArrayList<FlorAndFauna> element: islandLocationCells[i][j].arraysCell) {
                        for (FlorAndFauna arrayType: element) {
                            FlorAndFauna florAndFaun = (FlorAndFauna) arrayType;
                            System.out.print(florAndFaun.getEmoji());

                        }
                    }
                    System.out.println();
                }
            }

        }

    }
}
