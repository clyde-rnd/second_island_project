package herbivores;

public class Horse extends Herbivores{
    public static final String EMOJI_HORSE = "\uD83D\uDC34";
    public static final Float WEIGHT = 400f;
    public static final Integer MAX_AMOUNT = 20;
    public static final Integer MOVE_SPEED = 4;
    public static final Float HOW_MANY_FOOD_NEEDS = 60f;

    @Override
    public String getEmoji() {
        return EMOJI_HORSE;
    }
}
