package predator;

import herbivores.Rabbit;

public class Fox extends Predator{
    //emoji
    public static final String EMOJI_FOX= "\uD83E\uDD8A";
    public static final Float WEIGHT = 8f;
    public static final Integer MAX_AMOUNT = 30;
    public static final Integer MOVE_SPEED = 2;
    public static final Float HOW_MANY_FOOD_NEEDS = 2f;

    public Fox(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_FOX;
    }
    @Override
    public int maxSpeed() {
        return Fox.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
