package herbivores;

public class Boar extends Herbivores{
    //emoji
    public static final String EMOJI_BOAR = "\uD83D\uDC17";
    public static final Float WEIGHT = 400f;
    public static final Integer MAX_AMOUNT = 50;
    public static final Integer MOVE_SPEED = 2;
    public static final Float HOW_MANY_FOOD_NEEDS = 50f;

    @Override
    public String getEmoji() {
        return EMOJI_BOAR;
    }
}
