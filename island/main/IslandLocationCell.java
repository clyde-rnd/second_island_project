package island.main;

import island.herbivores.*;
import island.plants.Plants;
import island.predator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class  IslandLocationCell {
    public ArrayList<ArrayList> arraysCell = new ArrayList<>(Arrays.asList(
            new ArrayList<Wolf>(),
            new ArrayList<BoaConstrictor>(),
            new ArrayList<Fox>(),
            new ArrayList<Bear>(),
            new ArrayList<Eagle>(),
            new ArrayList<Horse>(),
            new ArrayList<Deer>(),
            new ArrayList<Rabbit>(),
            new ArrayList<Mouse>(),
            new ArrayList<Goat>(),
            new ArrayList<Sheep>(),
            new ArrayList<Boar>(),
            new ArrayList<Buffalo>(),
            new ArrayList<Duck>(),
            new ArrayList<Caterpillar>(),
            new ArrayList<Plants>()
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
