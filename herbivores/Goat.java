package herbivores;

public class Goat  extends Herbivores{
    //emoji
    public static final String EMOJI_GOAT = "\uD83D\uDC10";
    public static final Float WEIGHT = 60f;
    public static final Integer MAX_AMOUNT = 140;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 10f;

    public Goat(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_GOAT;
    }

    @Override
    public int maxSpeed() {
        return Goat.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
