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

    synchronized public boolean eat(FlorAndFauna florAndFauna, IslandLocationCell[][] islandLocationCells) {
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
                    florAndFauna.dead(islandLocationCells);
                    return true;
                }
            }
            return false;

    }

    public Animal reproduction() {
        return (Animal) generateRandomFlorAndFauna.AnimalCreator(this.getClass().getSimpleName());
    }

    public void move(int boardHeight, int boardWidth) {
        if ((ThreadLocalRandom.current().nextInt(1, 3)) % 2 == 0) {
            int amountStep = maxSpeed();
            int randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            int newX = x + randomStep;
            if (newX >= boardHeight) {
                newX = newX - boardHeight;
            } else if (newX < 0) {
                newX = newX + boardHeight;
            }
            randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            int newY = y + randomStep;
            if (newY >= boardWidth) {
                newY = newY - boardWidth;
            } else if (newY < 0) {
                newY = newY + boardWidth;
            }
            this.x = newX;
            this.y = newY;

        } else {
            int amountStep = maxSpeed();
            int randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            int newY = y + randomStep;
            if (newY >= boardWidth) {
                newY = newY - (boardHeight);
            } else if (newY < 0) {
                newY = newY + (boardHeight);
            }
            randomStep = ThreadLocalRandom.current().nextInt(-amountStep, amountStep + 1);
            amountStep = amountStep - Math.abs(randomStep);
            int newX = x + randomStep;
            if (newX >= boardHeight) {
                newX = newX - (boardHeight);
            } else if (newX < 0) {
                newX = newX + (boardHeight);
            }
            this.x = newX;
            this.y = newY;
        }
    }

    public void beEaten() {
        System.out.println("BeEaten");
    }

    @Override
    synchronized public boolean dead(IslandLocationCell[][] islandLocationCells) {
            int x = this.x;
            int y = this.y;
            int positionFlorAndFauna = GenerateRandomFlorAndFauna.POSITION.get(this.getClass().getSimpleName());
            int positionOnArray = islandLocationCells[x][y].arraysCell.get(positionFlorAndFauna).indexOf(this);
            if (positionOnArray != -1){
                islandLocationCells[x][y].arraysCell.get(positionFlorAndFauna).remove(positionOnArray);
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