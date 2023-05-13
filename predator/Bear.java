package predator;

public class Bear extends Predator{
    //emoji
    public static final String EMOJI_BEAR = "\uD83D\uDC3B";
    public static final Float WEIGHT = 500f;
    public static final Integer MAX_AMOUNT = 5;
    public static final Integer MOVE_SPEED = 2;
    public static final Float HOW_MANY_FOOD_NEEDS = 80f;

    @Override
    public String getEmoji() {
        return EMOJI_BEAR;
    }
}
