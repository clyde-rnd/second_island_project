package predator;

import main.Animal;
import main.FlorAndFauna;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public Predator(int x, int y) {
        super(x, y);
    }

    @Override
    public FlorAndFauna chooseVictim(CopyOnWriteArrayList<CopyOnWriteArrayList> islandLocation) {
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
