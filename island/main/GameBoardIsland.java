package island.main;

import island.plants.Plants;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardIsland {
    private int x;
    private int y;
    public volatile CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> gameBoardIslandArray;




    public void createGameBoard(int m, int n){
         gameBoardIslandArray = new CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>>();
        this.x=m;
        this.y=n;

        for (int i = 0; i < m; i++) {
            gameBoardIslandArray.add(new CopyOnWriteArrayList<IslandLocationCell>());
            for (int j = 0; j < n; j++) {
                gameBoardIslandArray.get(i).add(j, new IslandLocationCell(i,j));
                }
            }
    }

    public synchronized void moveAnimal (){
        synchronized (this) {
            for (int i = 0; i < gameBoardIslandArray.size(); i++) {
                for (int j = 0; j < gameBoardIslandArray.get(i).size(); j++) {
                    for (CopyOnWriteArrayList<FlorAndFauna> arrayFlorAndFaunaElement : gameBoardIslandArray.get(i).get(j).arraysCell) {
                        for (FlorAndFauna objectFlorAndFaunaElement : arrayFlorAndFaunaElement) {
                            //Проверяем может-ли данный вид передвигаться
                            if (objectFlorAndFaunaElement.maxSpeed() != 0) {
                                Animal animal = (Animal) objectFlorAndFaunaElement;
                                //меняем координаты у особи которую собераемся переместить
                                synchronized (this) {
                                    animal.move(this, this.x, this.y);
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public void eating (){
        synchronized(this) {
            for (int i = 0; i < gameBoardIslandArray.size(); i++) {
                for (int j = 0; j < gameBoardIslandArray.get(i).size(); j++) {
                    for (CopyOnWriteArrayList<FlorAndFauna> arraysCellElement : gameBoardIslandArray.get(i).get(j).arraysCell) {
                        for (FlorAndFauna florAndFaunaElement : arraysCellElement) {
                            if (!(florAndFaunaElement instanceof Plants) && florAndFaunaElement.getWeight() < florAndFaunaElement.getMaxWeight()) {
                                Animal animal = (Animal) florAndFaunaElement;
                                FlorAndFauna florAndFaunaVictim = animal.chooseVictim(gameBoardIslandArray.get(i).get(j).arraysCell);
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
            for (int i = 0; i < gameBoardIslandArray.size(); i++) {
                for (int j = 0; j < gameBoardIslandArray.get(i).size(); j++) {
                    CopyOnWriteArrayList<FlorAndFauna> animalArray = gameBoardIslandArray.get(i).get(j).arraysCell.get(ThreadLocalRandom.current().nextInt(0, 15));
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
        for (int i = 0; i < gameBoardIslandArray.size(); i++) {
            for (int j = 0; j < gameBoardIslandArray.get(i).size(); j++) {
                CopyOnWriteArrayList<Plants> arrayList = gameBoardIslandArray.get(i).get(j).arraysCell.get(GenerateRandomFlorAndFauna.POSITION.get("Plants"));
                for (Plants plants : arrayList) {
                    plants.grow();
                }
                //Добавляем по одному новому растеню для каждого списка чтобы поддерживать баланс
                arrayList.add(new Plants(i,j));
            }
        }
    }

    public synchronized void printEmojiGameBoard(){
        for (int i = 0; i < gameBoardIslandArray.size(); i++) {
            for (int j = 0; j < gameBoardIslandArray.get(i).size(); j++) {
                System.out.print("Cell - " + i + "X" + j + " ");
                for (CopyOnWriteArrayList<FlorAndFauna> element: gameBoardIslandArray.get(i).get(j).arraysCell) {
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
