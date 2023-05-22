package island.predator;

import island.main.Animal;
import island.main.FlorAndFauna;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public Predator(int x, int y) {
        super(x, y);
    }

    @Override
    public synchronized FlorAndFauna chooseVictim(ArrayList<ArrayList> islandLocation) {
        int count;
        int arrayNum = ThreadLocalRandom.current().nextInt(0, 15);
        count = islandLocation.get(arrayNum).size();
        if (count > 0) {
            return (FlorAndFauna) islandLocation.get(arrayNum).get(ThreadLocalRandom.current().nextInt(0, count));
        }else {
            return null;
        }

    }


}
