package main;


import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskGrowPlans implements Runnable {
    private volatile CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells = GamePlay.islandLocationCells;

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < islandLocationCells.size(); i++) {
                for (int j = 0; j < islandLocationCells.get(i).size(); j++) {
                    CopyOnWriteArrayList<Plants> arrayList = islandLocationCells.get(i).get(j).arraysCell.get(GenerateRandomFlorAndFauna.POSITION.get("Plants"));
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
