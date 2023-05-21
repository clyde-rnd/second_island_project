package main;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements FlorAndFauna {
    private volatile int x;
    private volatile int y;
    private float currentWeight;
    private GenerateRandomFlorAndFauna generateRandomFlorAndFauna = new GenerateRandomFlorAndFauna(x,y);

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //position
    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return getEmoji();
    }

    synchronized public boolean eat(FlorAndFauna florAndFauna) {
            String whoEaten;
            String whoIsBeingEaten;
            whoEaten = this.getClass().getSimpleName();
            whoIsBeingEaten = florAndFauna.getClass().getSimpleName();
            int chanceBeEaten = ChanceBeEaten.chanceBeEatenMethod(whoEaten, whoIsBeingEaten);
            if (chanceBeEaten > 0) {
                if ((ThreadLocalRandom.current().nextInt(1, 101)) <= chanceBeEaten) {
                    float needAddWeight = this.getMaxWeight() - getWeight();
                    float newWeight = Math.min((this.getWeight() + florAndFauna.getWeight()), this.getMaxWeight());
                    this.setWeight(newWeight);
                    florAndFauna.setWeight(florAndFauna.getWeight() - newWeight);
                    florAndFauna.death();
                    return true;
                }
            }
            return false;

    }

    public Animal reproduction() {
        Statistic.setStatisticBirthEvent(this.getEmoji()+"-Birth");
        return (Animal) generateRandomFlorAndFauna.AnimalCreator(this.getClass().getSimpleName());
    }

    synchronized public void move( int boardHeight, int boardWidth) {
        CopyOnWriteArrayList<CopyOnWriteArrayList<IslandLocationCell>> islandLocationCells = GamePlay.islandLocationCells;
        int newX;
        int newY;
        if ((ThreadLocalRandom.current().nextInt(1, 3)) % 2 == 0) {
            int amountStep = maxSpeed();
            int randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            newX = x + randomStep;
            if (newX >= boardHeight) {
                newX = newX - boardHeight;
            } else if (newX < 0) {
                newX = newX + boardHeight;
            }
            randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            newY = y + randomStep;
            if (newY >= boardWidth) {
                newY = newY - boardWidth;
            } else if (newY < 0) {
                newY = newY + boardWidth;
            }

        } else {
            int amountStep = maxSpeed();
            int randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            newY = y + randomStep;
            if (newY >= boardWidth) {
                newY = newY - (boardHeight);
            } else if (newY < 0) {
                newY = newY + (boardHeight);
            }
            randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            newX = x + randomStep;
            if (newX >= boardHeight) {
                newX = newX - (boardHeight);
            } else if (newX < 0) {
                newX = newX + (boardHeight);
            }


        }
        int positionFlorAndFauna = GenerateRandomFlorAndFauna.POSITION.get(this.getClass().getSimpleName());
        int positionOnArray = GamePlay.islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).indexOf(this);
        if (positionOnArray != -1){
            islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).remove(positionOnArray);
            //При перемещении особь теряет вес
            this.toLoseWeight();
            //Если вес  > 0, то то записываем новую позицию
            //довабляем на новуюю позицию в конец списка
            if (this.getWeight() >= 0) {
                this.x = newX;
                this.y = newY;
                islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).add(this);
            }else {
                Statistic.setDeathStatisticEvent(this.getEmoji()+"-"+"\uD83D\uDC80");
            }
        }

    }


    public void beEaten() {
        System.out.println("BeEaten");
    }

    @Override
    synchronized public boolean death() {
            int positionFlorAndFauna = GenerateRandomFlorAndFauna.POSITION.get(this.getClass().getSimpleName());
            int positionOnArray = GamePlay.islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).indexOf(this);
            if (positionOnArray != -1){
                GamePlay.islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).remove(positionOnArray);
                Statistic.setDeathStatisticEvent(this.getEmoji()+"-"+"\uD83D\uDC80");
            }

            return true;

    }

    @Override
    public float getWeight() {
        return currentWeight;
    }

    @Override

    public void setWeight(float weight) {
        this.currentWeight = weight;
    }

    public void toLoseWeight() {
        this.currentWeight = this.currentWeight - getMaxWeight() * 0.1f;
    }

    public abstract FlorAndFauna chooseVictim(CopyOnWriteArrayList<CopyOnWriteArrayList> islandLocation);
}