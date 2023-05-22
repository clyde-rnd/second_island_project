package island.herbivores;

public class Deer extends Herbivores{
    //emoji
    public static final String EMOJI_DEER = "\uD83E\uDD8C";
    public static final Float WEIGHT = 300f;
    public static final Integer MAX_AMOUNT = 20;
    public static final Integer MOVE_SPEED = 4;
    public static final Float HOW_MANY_FOOD_NEEDS = 50f;

    public Deer(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_DEER;
    }
    @Override
    public int maxSpeed() {
        return Deer.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }
}
