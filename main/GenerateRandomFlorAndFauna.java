package main;

import herbivores.*;
import plants.Plants;
import predator.*;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomFlorAndFauna {
    private int x;
    private int y;
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    public GenerateRandomFlorAndFauna(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static final String[] arrayClassName = {
            "Wolf",
            "BoaConstrictor",
            "Fox",
            "Bear",
            "Eagle",
            "Horse",
            "Deer",
            "Rabbit",
            "Mouse",
            "Goat",
            "Sheep",
            "Boar",
            "Buffalo",
            "Duck",
            "Caterpillar",
            "Plants"
    };
    public FlorAndFauna randomAnimalCreator (){
        String nameClass = arrayClassName[random.nextInt(0,15)];
        return switch (nameClass) {
            case "Wolf" -> new Wolf();
            case "BoaConstrictor" -> new BoaСonstrictor();
            case "Fox" -> new Fox();
            case "Bear" -> new Bear();
            case "Eagle" -> new Eagle();
            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Boar" -> new Boar();
            case "Buffalo" -> new Buffalo();
            case "Duck" -> new Duck();
            case "Caterpillar" -> new Caterpillar();
            default -> throw new RuntimeException();
        };
    }

    public Predator randomPredatorCreator (){
        String nameClass = arrayClassName[random.nextInt(0,5)];
        return switch (nameClass) {
            case "Wolf" -> new Wolf();
            case "BoaConstrictor" -> new BoaСonstrictor();
            case "Fox" -> new Fox();
            case "Bear" -> new Bear();
            case "Eagle" -> new Eagle();
            default -> throw new RuntimeException();
        };
    }

    public Herbivores randomHerbivoresCreator(){
        String nameClass = arrayClassName[random.nextInt(5,15)];
        return switch (nameClass) {
            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Boar" -> new Boar();
            case "Buffalo" -> new Buffalo();
            case "Duck" -> new Duck();
            case "Caterpillar" -> new Caterpillar();
            default -> throw new RuntimeException();
        };

    }

    public Plants createPlants(){
        return new Plants(this.x, this.y);
    }
}
