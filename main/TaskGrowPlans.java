package main;


import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskGrowPlans implements Runnable {
    private volatile IslandLocationCell[][] islandLocationCells;

    public TaskGrowPlans(IslandLocationCell[][] islandLocationCells) {
        this.islandLocationCells = islandLocationCells;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < islandLocationCells.length; i++) {
                for (int j = 0; j < islandLocationCells[i].length; j++) {
                    CopyOnWriteArrayList<Plants> arrayList = islandLocationCells[i][j].arraysCell.get(GenerateRandomFlorAndFauna.POSITION.get("Plants"));
                    for (Plants plants : arrayList) {
                        plants.grow();
                    }
                    //Добавляем по одному новому растеню для каждого списка чтобы поддерживать баланс
                    arrayList.add(new Plants(i,j));
                    }
                }
        }

    }
}
