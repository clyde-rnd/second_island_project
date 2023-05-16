package herbivores;

public class Caterpillar extends Herbivores{
    //emoji
    public static final String EMOJI_CATERPILLAR = "\uD83D\uDC1B";
    public static final Float WEIGHT = 0.01f;
    public static final Integer MAX_AMOUNT = 1000;
    public static final Integer MOVE_SPEED = 0;
    public static final Float HOW_MANY_FOOD_NEEDS = 0f;

    public Caterpillar(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_CATERPILLAR;
    }
    @Override
    public int maxSpeed() {
        return Caterpillar.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
