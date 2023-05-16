package main;

import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskToMoveAnimal implements Runnable{
    private IslandLocationCell[][] islandLocationCells;
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
                            if(objectFlorAndFaunaElement.maxSpeed()!=0){
                                Animal tempAnimal = (Animal) objectFlorAndFaunaElement;
                                //При перемещении особь теряет вес
                                tempAnimal.toLoseWeight();
                                //Если вес стал меньше или равен 0, то избавляемся от этой осаби
                                if(tempAnimal.getWeight()<=0){
                                    //tempAnimal.Dead();
                                    tempAnimal.dead(islandLocationCells);
                                    //Если вес нормальный, то перемещаемся
                                }else {

                                    //удаляем ее со старой прозиции
                                    tempAnimal.dead(islandLocationCells);
                                    //менфем координаты у особи которую собераемся переместить
                                    tempAnimal.move(boardHeight, boardWidth);

                                    //довабляем на новуюю позицию в конец списка
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

