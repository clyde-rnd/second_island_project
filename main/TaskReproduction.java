package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskReproduction implements Runnable{



    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now() + " TaskReproduction  Started");
            reproduction(GamePlay.islandLocationCells);

        }
    }

    private void reproduction(CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells) {
        for (int i = 0; i < islandLocationCells.size(); i++) {
            for (int j = 0; j < islandLocationCells.get(i).size(); j++) {
                CopyOnWriteArrayList<FlorAndFauna> animalArray = islandLocationCells.get(i).get(j).arraysCell.get(ThreadLocalRandom.current().nextInt(0, 15));
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
