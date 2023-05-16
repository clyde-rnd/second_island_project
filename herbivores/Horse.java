package herbivores;

public class Horse extends Herbivores{
    public static final String EMOJI_HORSE = "\uD83D\uDC34";
    public static final Float WEIGHT = 400f;
    public static final Integer MAX_AMOUNT = 20;
    public static final Integer MOVE_SPEED = 4;
    public static final Float HOW_MANY_FOOD_NEEDS = 60f;

    public Horse(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_HORSE;
    }
    @Override
    public int maxSpeed() {
        return Horse.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
