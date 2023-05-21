package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskToMoveAnimal implements Runnable{
    private volatile CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells= GamePlay.islandLocationCells;
    private int boardHeight;
    private int boardWidth;

    public TaskToMoveAnimal( int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskToMoveAnimal Started");
            for (int i = 0; i < islandLocationCells.size(); i++) {
                for (int j = 0; j < islandLocationCells.get(i).size(); j++) {
                    for (CopyOnWriteArrayList<FlorAndFauna> arrayFlorAndFaunaElement: islandLocationCells.get(i).get(j).arraysCell) {
                        for (FlorAndFauna objectFlorAndFaunaElement : arrayFlorAndFaunaElement) {
                                //Проверяем может-ли данный вид передвигаться
                                if (objectFlorAndFaunaElement.maxSpeed() != 0) {
                                    Animal animal = (Animal) objectFlorAndFaunaElement;
                                    //меняем координаты у особи которую собераемся переместить
                                    animal.move( boardHeight, boardWidth);
                                }
                            }

                        }
                    }
                }
            }

    }
}

