package predator;

public class Eagle extends Predator{
    //emoji
    public static final String EMOJI_EAGLE = "\uD83E\uDD85";
    public static final Float WEIGHT = 6f;
    public static final Integer MAX_AMOUNT = 20;
    public static final Integer MOVE_SPEED = 3;
    public static final Float HOW_MANY_FOOD_NEEDS = 1f;

    @Override
    public String getEmoji() {
        return EMOJI_EAGLE;
    }
}
