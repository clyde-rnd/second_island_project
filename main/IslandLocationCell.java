package main;

import herbivores.*;
import plants.Plants;
import predator.*;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class  IslandLocationCell {
    public CopyOnWriteArrayList<CopyOnWriteArrayList> arraysCell = new CopyOnWriteArrayList<>(Arrays.asList(
            new CopyOnWriteArrayList<Wolf>(),
            new CopyOnWriteArrayList<BoaConstrictor>(),
            new CopyOnWriteArrayList<Fox>(),
            new CopyOnWriteArrayList<Bear>(),
            new CopyOnWriteArrayList<Eagle>(),
            new CopyOnWriteArrayList<Horse>(),
            new CopyOnWriteArrayList<Deer>(),
            new CopyOnWriteArrayList<Rabbit>(),
            new CopyOnWriteArrayList<Mouse>(),
            new CopyOnWriteArrayList<Goat>(),
            new CopyOnWriteArrayList<Sheep>(),
            new CopyOnWriteArrayList<Boar>(),
            new CopyOnWriteArrayList<Buffalo>(),
            new CopyOnWriteArrayList<Duck>(),
            new CopyOnWriteArrayList<Caterpillar>(),
            new CopyOnWriteArrayList<Plants>()
    ));

   private int x;
   private int y;
   private int amountPlants = 30;
   private int amountPredator = 10;
   private int amountHerbivores = 20;
   private GenerateRandomFlorAndFauna generateRandomFlorAndFauna;
    public IslandLocationCell(int x, int y) {
        this.x = x;
        this.y = y;
        generateRandomFlorAndFauna = new GenerateRandomFlorAndFauna(this.x, this.y);
        addFlorAndFauna();
    }

    private void addFlorAndFauna(){
        for (int i = 0; i < amountPlants; i++) {
            int indexPlants = GenerateRandomFlorAndFauna.POSITION.get("Plants");
            arraysCell.get(indexPlants).add(generateRandomFlorAndFauna.createPlants());
        }

        for (int i = 0; i < amountPredator; i++) {
            Predator predator = generateRandomFlorAndFauna.randomPredatorCreator();
            String namePredator = predator.getClass().getSimpleName();
            int indexPredator = GenerateRandomFlorAndFauna.POSITION.get(namePredator);
            arraysCell.get(indexPredator).add(predator);
        }

        for (int i = 0; i < amountHerbivores; i++) {
            Herbivores herbivores = generateRandomFlorAndFauna.randomHerbivoresCreator();
            String nameHerbivores = herbivores.getClass().getSimpleName();
            int indexHerbivores = GenerateRandomFlorAndFauna.POSITION.get(nameHerbivores);
            arraysCell.get(indexHerbivores).add(herbivores);
        }
    }

}
