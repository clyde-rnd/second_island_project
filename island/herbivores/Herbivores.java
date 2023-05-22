package island.herbivores;

import island.main.Animal;
import island.main.FlorAndFauna;
import island.main.GenerateRandomFlorAndFauna;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivores extends Animal {
    public Herbivores(int x, int y) {
        super(x, y);
    }

    @Override
    public synchronized FlorAndFauna chooseVictim(ArrayList<ArrayList> islandLocation) {
        int count;
        int position;

        if (this instanceof Duck || this instanceof Mouse){
            int [] array = {GenerateRandomFlorAndFauna.POSITION.get("Caterpillar"), GenerateRandomFlorAndFauna.POSITION.get("Plants")};
            position = array[ThreadLocalRandom.current().nextInt(0, array.length)];
        } else if (this instanceof Boar) {
            int [] array = {GenerateRandomFlorAndFauna.POSITION.get("Caterpillar"),
                    GenerateRandomFlorAndFauna.POSITION.get("Plants"), GenerateRandomFlorAndFauna.POSITION.get("Mouse")};
            position = array[ThreadLocalRandom.current().nextInt(0, array.length)];

        }else {
            position = GenerateRandomFlorAndFauna.POSITION.get("Plants");
        }

        count = islandLocation.get(position).size();
        if (count > 0) {
            return (FlorAndFauna) islandLocation.get(position).get(ThreadLocalRandom.current().nextInt(0, count));
        }
        return null;
    }
}
