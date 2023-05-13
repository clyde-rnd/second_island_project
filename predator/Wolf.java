package predator;

public class Wolf extends Predator{
    //emoji
    public static final String EMOJI_WOLF= "\uD83D\uDC3A";
    public static final Float WEIGHT = 50f;
    public static final Integer MAX_AMOUNT = 30;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 8f;

    @Override
    public String getEmoji() {
        return EMOJI_WOLF;
    }
}
