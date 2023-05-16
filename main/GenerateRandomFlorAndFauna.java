package main;

import herbivores.*;
import plants.Plants;
import predator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomFlorAndFauna {
    private int x;
    private int y;
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    public GenerateRandomFlorAndFauna(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final static Map<String, Integer> POSITION = new HashMap<>(){{
        put("Wolf", 0);
        put("BoaСonstrictor", 1);
        put("Fox", 2);
        put("Bear", 3);
        put("Eagle", 4);
        put("Horse", 5);
        put("Deer", 6);
        put("Rabbit", 7);
        put("Mouse", 8);
        put("Goat", 9);
        put("Sheep", 10);
        put("Boar", 11);
        put("Buffalo", 12);
        put("Duck", 13);
        put("Caterpillar", 14);
        put("Plants", 15);

    }};
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
            case "Wolf" -> new Wolf(this.x, this.y);
            case "BoaConstrictor" -> new BoaСonstrictor(this.x, this.y);
            case "Fox" -> new Fox(this.x, this.y);
            case "Bear" -> new Bear(this.x, this.y);
            case "Eagle" -> new Eagle(this.x, this.y);
            case "Horse" -> new Horse(this.x, this.y);
            case "Deer" -> new Deer(this.x, this.y);
            case "Rabbit" -> new Rabbit(this.x, this.y);
            case "Mouse" -> new Mouse(this.x, this.y);
            case "Goat" -> new Goat(this.x, this.y);
            case "Sheep" -> new Sheep(this.x, this.y);
            case "Boar" -> new Boar(this.x, this.y);
            case "Buffalo" -> new Buffalo(this.x, this.y);
            case "Duck" -> new Duck(this.x, this.y);
            case "Caterpillar" -> new Caterpillar(this.x, this.y);
            default -> throw new RuntimeException();
        };
    }

    public Predator randomPredatorCreator (){
        String nameClass = arrayClassName[random.nextInt(0,5)];
        return switch (nameClass) {
            case "Wolf" -> new Wolf(this.x, this.y);
            case "BoaConstrictor" -> new BoaСonstrictor(this.x, this.y);
            case "Fox" -> new Fox(this.x, this.y);
            case "Bear" -> new Bear(this.x, this.y);
            case "Eagle" -> new Eagle(this.x, this.y);
            default -> throw new RuntimeException();
        };
    }

    public Herbivores randomHerbivoresCreator(){
        String nameClass = arrayClassName[random.nextInt(5,15)];
        return switch (nameClass) {
            case "Horse" -> new Horse(this.x, this.y);
            case "Deer" -> new Deer(this.x, this.y);
            case "Rabbit" -> new Rabbit(this.x, this.y);
            case "Mouse" -> new Mouse(this.x, this.y);
            case "Goat" -> new Goat(this.x, this.y);
            case "Sheep" -> new Sheep(this.x, this.y);
            case "Boar" -> new Boar(this.x, this.y);
            case "Buffalo" -> new Buffalo(this.x, this.y);
            case "Duck" -> new Duck(this.x, this.y);
            case "Caterpillar" -> new Caterpillar(this.x, this.y);
            default -> throw new RuntimeException();
        };

    }

    public Plants createPlants(){
        return new Plants(this.x, this.y);
    }
}
