package main;

import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskOfEating implements Runnable{
    private volatile CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells = GamePlay.islandLocationCells;


        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println(LocalDateTime.now() + " TaskOfEating Started");
                for (int i = 0; i < islandLocationCells.size(); i++) {
                    for (int j = 0; j < islandLocationCells.get(i).size(); j++) {
                        for (CopyOnWriteArrayList<FlorAndFauna> arraysCellElement : islandLocationCells.get(i).get(j).arraysCell) {
                            for (FlorAndFauna florAndFaunaElement : arraysCellElement) {
                                if (!(florAndFaunaElement instanceof Plants) && florAndFaunaElement.getWeight() < florAndFaunaElement.getMaxWeight()) {
                                    Animal animal = (Animal) florAndFaunaElement;
                                    FlorAndFauna florAndFaunaVictim = animal.chooseVictim(islandLocationCells.get(i).get(j).arraysCell);
                                    //если жертва найдена, то пробуем ее съесть
                                    if (florAndFaunaVictim != null) {
                                        boolean isEat = animal.eat(florAndFaunaVictim);
                                        if (isEat) {
                                            Statistic.setEatStatisticEvent(animal.getEmoji() + "съел" + florAndFaunaVictim.getEmoji());
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
