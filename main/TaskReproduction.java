package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskReproduction implements Runnable{
    private volatile IslandLocationCell[][] islandLocationCells;

    public TaskReproduction(IslandLocationCell[][] islandLocationCells) {
        this.islandLocationCells = islandLocationCells;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now() + " TaskReproduction  Started");
            reproduction(islandLocationCells);

        }
    }

    private void reproduction(IslandLocationCell[][] islandLocationCells) {
        for (int i = 0; i < islandLocationCells.length; i++) {
            for (int j = 0; j < islandLocationCells[i].length; j++) {
                CopyOnWriteArrayList<FlorAndFauna> animalArray = islandLocationCells[i][j].arraysCell.get(ThreadLocalRandom.current().nextInt(0, 15));
                int size = animalArray.size();
                if (size > 1) {
                    Animal animal = (Animal) animalArray.get(ThreadLocalRandom.current().nextInt(0, size));
                    Animal newAnimal = animal.reproduction();
                    animalArray.add(newAnimal);
                }

            }

        }
    }
}
