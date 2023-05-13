package main;

import predator.Eagle;

import java.util.HashMap;
import java.util.Map;

public class СhanceBeEaten {
   private final static Map<String, Integer> POSITION = new HashMap<>(){{
        put("Wolf", 0);
        put("BoaConstrictor", 1);
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

    private static final int[][] ARRAY_OF_PROBABILITIES = {
            {0,	0,	0,	0,	0,	10,	15,	60,	80,	60,	70,	15,	10,	40,	0,	0},
            {0,	0,	15,	0,	0,	0,	0,	20,	40,	0,	0,	0,	0,	10,	0,	0},
            {0,	0,	0,	0,	0,	0,	0,	70,	90,	0,	0,	0,	0,	60,	40,	0},
            {0,	80,	0,	0,	0,	40,	80,	80,	90,	70,	70,	50,	20,	10,	0,	0},
            {0,	0,	10,	0,	0,	0,	0,	90,	90,	0,	0,	0,	0,	80,	0,	0},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	90,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	50,	0,	0,	0,	0,	0,	90,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	90,	100},
            {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	100},
    };

    public static int chanceBeEatenMethod(String whoEaten, String whoIsBeingEaten){
        if(whoEaten.equals(whoIsBeingEaten)){
            return 0;
        }

        int positionWhoEaten;
        int positionWhoIsBeingEaten;

        positionWhoEaten = POSITION.get(whoEaten);
        positionWhoIsBeingEaten = POSITION.get(whoIsBeingEaten);

        return ARRAY_OF_PROBABILITIES[positionWhoEaten][positionWhoIsBeingEaten];

    }
}
