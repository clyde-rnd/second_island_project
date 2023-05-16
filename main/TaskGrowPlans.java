package main;


import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskGrowPlans implements Runnable {
    private IslandLocationCell[][] islandLocationCells;

    public TaskGrowPlans(IslandLocationCell[][] islandLocationCells) {
        this.islandLocationCells = islandLocationCells;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskGrowPlans Started");
            for (int i = 0; i < islandLocationCells.length; i++) {
                for (int j = 0; j < islandLocationCells[i].length; j++) {
                    CopyOnWriteArrayList<Plants> arrayList = islandLocationCells[i][j].arraysCell.get(GenerateRandomFlorAndFauna.POSITION.get("Plants"));
                    for (Plants plants : arrayList) {
                        plants.grow();
                    }
                    }
                }
        }

    }
}
