package herbivores;

import main.Animal;
import main.FlorAndFauna;
import main.GenerateRandomFlorAndFauna;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivores extends Animal {
    public Herbivores(int x, int y) {
        super(x, y);
    }

    @Override
    public FlorAndFauna chooseVictim(CopyOnWriteArrayList<CopyOnWriteArrayList> islandLocation) {
        int count;
        if (this instanceof Duck) {
            count = islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Caterpillar")).size();
            if (count > 0) {
                return (FlorAndFauna) islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Caterpillar")).get(ThreadLocalRandom.current().nextInt(0, count));
            } else {
                count = islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Plants")).size();
                if (count > 0) {
                    return (FlorAndFauna) islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Plants")).get(ThreadLocalRandom.current().nextInt(0, count));
                }else return null;
            }
        }else {
            count = islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Plants")).size();
            if (count > 0) {
                return (FlorAndFauna) islandLocation.get(GenerateRandomFlorAndFauna.POSITION.get("Plants")).get(ThreadLocalRandom.current().nextInt(0, count));
            }
        }
        return null;
    }
}
