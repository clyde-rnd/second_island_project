package herbivores;

public class Buffalo extends Herbivores{
    //emoji
    public static final String EMOJI_BUFFALO = "\uD83D\uDC03";
    public static final Float WEIGHT = 700f;
    public static final Integer MAX_AMOUNT = 10;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 100f;

    public Buffalo(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_BUFFALO;
    }
    @Override
    public int maxSpeed() {
        return Buffalo.MOVE_SPEED;
    }

    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
