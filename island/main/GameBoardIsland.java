package island.main;

import island.plants.Plants;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardIsland {
    private int x;
    private int y;
    public volatile  IslandLocationCell[][] gameBoardIslandArray;




    public void createGameBoard(int m, int n){
         gameBoardIslandArray = new IslandLocationCell[m][n];
        this.x=m;
        this.y=n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoardIslandArray[i][j] = new IslandLocationCell(i,j);
                }
            }
    }

    public synchronized void moveAnimal (){
        synchronized (this) {
            for (int i = 0; i < gameBoardIslandArray.length; i++) {
                for (int j = 0; j < gameBoardIslandArray[i].length; j++) {
                    for (ArrayList<FlorAndFauna> arrayFlorAndFaunaElement : gameBoardIslandArray[i][j].arraysCell) {
                        for (int k = 0; k < arrayFlorAndFaunaElement.size(); k++) {
                            FlorAndFauna objectFlorAndFaunaElement = arrayFlorAndFaunaElement.get(k);
                            //Проверяем может-ли данный вид передвигаться
                            if (objectFlorAndFaunaElement.maxSpeed() != 0) {
                                Animal animal = (Animal) objectFlorAndFaunaElement;
                                //меняем координаты у особи которую собераемся переместить
                                    animal.move(this, this.x, this.y);
                            }
                        }

                    }
                }
            }
        }
    }

    public void eating (){
        synchronized(this) {
            for (int i = 0; i < gameBoardIslandArray.length; i++) {
                for (int j = 0; j < gameBoardIslandArray[i].length; j++) {
                    for (ArrayList<FlorAndFauna> arraysCellElement : gameBoardIslandArray[i][j].arraysCell) {
                        for (FlorAndFauna florAndFaunaElement : arraysCellElement) {
                            if (!(florAndFaunaElement instanceof Plants) && florAndFaunaElement.getWeight() < florAndFaunaElement.getMaxWeight()) {
                                Animal animal = (Animal) florAndFaunaElement;
                                FlorAndFauna florAndFaunaVictim = animal.chooseVictim(gameBoardIslandArray[i][j].arraysCell);
                                //если жертва найдена, то пробуем ее съесть
                                if (florAndFaunaVictim != null) {
                                    boolean isEat = animal.eat(gameBoardIslandArray, florAndFaunaVictim);
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

    public void reproduction() {
        synchronized(this) {
            for (int i = 0; i < gameBoardIslandArray.length; i++) {
                for (int j = 0; j < gameBoardIslandArray[i].length; j++) {
                    ArrayList<FlorAndFauna> animalArray = gameBoardIslandArray[i][j].arraysCell.get(ThreadLocalRandom.current().nextInt(0, 15));
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

    public synchronized void growPlans (){
        for (int i = 0; i < gameBoardIslandArray.length; i++) {
            for (int j = 0; j < gameBoardIslandArray[i].length; j++) {
               ArrayList<Plants> arrayList = gameBoardIslandArray[i][j].arraysCell.get(GenerateRandomFlorAndFauna.POSITION.get("Plants"));
                for (Plants plants : arrayList) {
                    plants.grow();
                }
                //Добавляем по одному новому растеню для каждого списка чтобы поддерживать баланс
                arrayList.add(new Plants(i,j));
            }
        }
    }

    public synchronized void printEmojiGameBoard(){
        for (int i = 0; i < gameBoardIslandArray.length; i++) {
            for (int j = 0; j < gameBoardIslandArray[i].length; j++) {
                System.out.print("Cell - " + i + "X" + j + " ");
                for (ArrayList<FlorAndFauna> element: gameBoardIslandArray[i][j].arraysCell) {
                    for (FlorAndFauna florAndFaunElement: element) {
                        if (florAndFaunElement instanceof Plants){
                            System.out.print(florAndFaunElement.getEmoji()+"-"+((Plants) florAndFaunElement).getCurrentWeight());
                        }else {
                            System.out.print(florAndFaunElement.getEmoji());
                        }

                    }
                }
                System.out.println();
            }
        }
    }

}
