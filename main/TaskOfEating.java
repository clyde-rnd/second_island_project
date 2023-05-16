package main;

import plants.Plants;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskOfEating implements Runnable{

    private IslandLocationCell[][] islandLocationCells;

    public TaskOfEating(IslandLocationCell[][] islandLocationCells) {
            this.islandLocationCells = islandLocationCells;
        }
        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println(LocalDateTime.now()+" TaskOfEating Started");
                for (int i = 0; i < islandLocationCells.length; i++) {
                    for (int j = 0; j < islandLocationCells[i].length; j++) {
                        for (CopyOnWriteArrayList<FlorAndFauna> element: islandLocationCells[i][j].arraysCell) {
                            for (FlorAndFauna florAndFaunaElementArray : element) {
                                FlorAndFauna florAndFaun = (FlorAndFauna) florAndFaunaElementArray;
                                if (!(florAndFaun instanceof Plants) && florAndFaun.getWeight()<florAndFaun.getMaxWeight()){
                                    //System.out.println(florAndFaun.getClass().getSimpleName()+" Уже готов покушать");

                                }
                            }
                        }
                    }
                }

            }

        }
}
