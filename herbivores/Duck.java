package herbivores;

public class Duck extends Herbivores{
    //emoji
    public static final String EMOJI_DUCK = "\uD83E\uDD86";
    public static final Float WEIGHT = 1f;
    public static final Integer MAX_AMOUNT = 200;
    public static final Integer MOVE_SPEED = 4;
    public static final Float HOW_MANY_FOOD_NEEDS = 0.15f;

    public Duck(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_DUCK;
    }
    @Override
    public int maxSpeed() {
        return Duck.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
