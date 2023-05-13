package predator;

public class BoaСonstrictor extends Predator{
    //emoji
    public static final String EMOJI_BOA_CONSTRICTOR = "\uD83D\uDC0D";
    public static final Float WEIGHT = 15f;
    public static final Integer MAX_AMOUNT = 30;
    public static final Integer MOVE_SPEED = 1;
    public static final Float HOW_MANY_FOOD_NEEDS = 3f;
    @Override
    public String getEmoji() {
        return EMOJI_BOA_CONSTRICTOR;
    }



}
