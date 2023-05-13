package herbivores;

public class Mouse extends Herbivores{
    //emoji
    public static final String EMOJI_MOUSE = "\uD83D\uDC2D";
    public static final Float WEIGHT = 0.05f;
    public static final Integer MAX_AMOUNT = 500;
    public static final Integer MOVE_SPEED = 1;
    public static final Float HOW_MANY_FOOD_NEEDS = 0.01f;

    @Override
    public String getEmoji() {
        return EMOJI_MOUSE;
    }


}
