package predator;

import herbivores.Rabbit;

public class Wolf extends Predator{
    //emoji
    public static final String EMOJI_WOLF= "\uD83D\uDC3A";
    public static final Float WEIGHT = 50f;
    public static final Integer MAX_AMOUNT = 30;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 8f;

    public Wolf(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_WOLF;
    }
    @Override
    public int maxSpeed() {
        return Wolf.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
