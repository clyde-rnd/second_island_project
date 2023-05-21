package main;

import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskOfEating implements Runnable{

    private volatile IslandLocationCell[][] islandLocationCells;

    public TaskOfEating(IslandLocationCell[][] islandLocationCells) {
            this.islandLocationCells = islandLocationCells;
        }
        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println(LocalDateTime.now() + " TaskOfEating Started");
                for (int i = 0; i < islandLocationCells.length; i++) {
                    for (int j = 0; j < islandLocationCells[i].length; j++) {
                        for (CopyOnWriteArrayList<FlorAndFauna> arraysCellElement : islandLocationCells[i][j].arraysCell) {
                            for (FlorAndFauna florAndFaunaElement : arraysCellElement) {
                                if (!(florAndFaunaElement instanceof Plants) && florAndFaunaElement.getWeight() < florAndFaunaElement.getMaxWeight()) {
                                    Animal animal = (Animal) florAndFaunaElement;
                                    FlorAndFauna florAndFaunaVictim = animal.chooseVictim(islandLocationCells[i][j].arraysCell);
                                    //если жертва найдена, то пробуем ее съесть
                                    if (florAndFaunaVictim != null) {
                                        boolean isEat = animal.eat(florAndFaunaVictim, islandLocationCells);
                                        if (isEat) {
                                            Statistic.setStatisticEvent(animal.getEmoji() + "съел" + florAndFaunaVictim.getEmoji());
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }

            }
}
