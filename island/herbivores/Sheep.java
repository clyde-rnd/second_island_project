package island.herbivores;

public class Sheep extends Herbivores{
    //emoji
    public static final String EMOJI_SHEEP = "\uD83D\uDC11";
    public static final Float WEIGHT = 70f;
    public static final Integer MAX_AMOUNT = 140;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 15f;

    public Sheep(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }

    @Override
    public String getEmoji() {
        return EMOJI_SHEEP;
    }

    @Override
    public int maxSpeed() {
        return Sheep.MOVE_SPEED;
    }
}
