package island.herbivores;

public class Rabbit extends Herbivores{
    //emoji
    public static final String EMOJI_RABBIT = "\uD83D\uDC30";
    public static final Float WEIGHT = 2f;
    public static final Integer MAX_AMOUNT = 150;
    public static final Integer MOVE_SPEED = 2;
    public static final Float HOW_MANY_FOOD_NEEDS = 0.45f;

    public Rabbit(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_RABBIT;
    }
    @Override
    public int maxSpeed() {
        return Rabbit.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }


}
