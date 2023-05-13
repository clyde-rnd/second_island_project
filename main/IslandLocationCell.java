package main;

import herbivores.*;
import plants.Plants;
import predator.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class IslandLocationCell {
   private int x;
   private int y;
   private int amountPlants = 100;
   private int amountPredator = 100;
   private int amountHerbivores = 50;
   private GenerateRandomFlorAndFauna generateRandomFlorAndFauna = new GenerateRandomFlorAndFauna(this.x, this.y);
   public CopyOnWriteArrayList<Plants> islandPlants;
   public CopyOnWriteArrayList<Predator> islandPredator;
   public CopyOnWriteArrayList<Herbivores> islandHerbivores;


    public IslandLocationCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.islandPlants = addPlants(amountPlants);
        this.islandPredator = addPredator(amountPredator);
        this.islandHerbivores = addHerbivores(amountHerbivores);
    }

    private CopyOnWriteArrayList<Plants> addPlants(int amountPlants){
        CopyOnWriteArrayList<Plants> arrayListPlants = new CopyOnWriteArrayList<>();
        for (int i = 0; i < amountPlants ; i++) {
            arrayListPlants.add(i, generateRandomFlorAndFauna.createPlants());
        }
        return arrayListPlants;
    }

    private CopyOnWriteArrayList<Predator> addPredator(int amountPlants){
        CopyOnWriteArrayList<Predator> arrayListPredator = new CopyOnWriteArrayList<>();
        for (int i = 0; i < amountPredator ; i++) {
            arrayListPredator.add(i, generateRandomFlorAndFauna.randomPredatorCreator());
        }
        return arrayListPredator;
    }

    private CopyOnWriteArrayList<Herbivores> addHerbivores(int amountPlants){
        CopyOnWriteArrayList<Herbivores> arrayListHerbivores = new CopyOnWriteArrayList<>();
        for (int i = 0; i < amountHerbivores ; i++) {
            arrayListHerbivores.add(i, generateRandomFlorAndFauna.randomHerbivoresCreator());
        }
        return arrayListHerbivores;
    }



    @Override
    public String toString() {
        return "IslandLocationCell{" +
                "x=" + x +
                ", y=" + y +
                ", amountPlants=" + amountPlants +
                ", amountPredator=" + amountPredator +
                ", amountHerbivores=" + amountHerbivores +
                ", generateRandomFlorAndFauna=" + generateRandomFlorAndFauna +
                ", islandPlants=" + islandPlants.toString()  +
                ", islandPredator=" + islandPredator +
                ", islandHerbivores=" + islandHerbivores +
                '}';
    }
}
