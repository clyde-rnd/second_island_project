package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskToMoveAnimal implements Runnable{
    private volatile IslandLocationCell[][] islandLocationCells;
    private int boardHeight;
    private int boardWidth;

    public TaskToMoveAnimal(IslandLocationCell[][] islandLocationCells, int boardHeight, int boardWidth) {
        this.islandLocationCells = islandLocationCells;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(LocalDateTime.now()+" TaskToMoveAnimal Started");
            for (int i = 0; i < islandLocationCells.length; i++) {
                for (int j = 0; j < islandLocationCells[i].length; j++) {
                    for (CopyOnWriteArrayList<FlorAndFauna> arrayFlorAndFaunaElement: islandLocationCells[i][j].arraysCell) {
                        for (FlorAndFauna objectFlorAndFaunaElement : arrayFlorAndFaunaElement) {
                            int positionOnArraysCell = GenerateRandomFlorAndFauna.POSITION.get(objectFlorAndFaunaElement.getClass().getSimpleName());
                            int positionOnArray = arrayFlorAndFaunaElement.indexOf(objectFlorAndFaunaElement);
                            //Проверяем могжет-ли данный вид передвигаться
                            if (objectFlorAndFaunaElement.maxSpeed() != 0) {
                                Animal tempAnimal = (Animal) objectFlorAndFaunaElement;
                                //удаляем ее со старой прозиции
                                tempAnimal.dead(islandLocationCells);
                                //меняем координаты у особи которую собераемся переместить
                                tempAnimal.move(boardHeight, boardWidth);
                                //При перемещении особь теряет вес
                                tempAnimal.toLoseWeight();
                                //Если вес  > 0, то то записываем новую позицию
                                //довабляем на новуюю позицию в конец списка
                                if (tempAnimal.getWeight() >= 0) {
                                    islandLocationCells[tempAnimal.getX()][tempAnimal.getY()].arraysCell.get(positionOnArraysCell).add(tempAnimal);
                                }
                            }
                        }
                        }
                    }
                }
            }

    }
}

