package predator;

public class BoaConstrictor extends Predator{
    //emoji
    public static final String EMOJI_BOA_CONSTRICTOR = "\uD83D\uDC0D";
    public static final Float WEIGHT = 15f;
    public static final Integer MAX_AMOUNT = 30;
    public static final Integer MOVE_SPEED = 1;
    public static final Float HOW_MANY_FOOD_NEEDS = 3f;

    public BoaConstrictor(int x, int y) {
        super(x, y);
        setWeight(WEIGHT);
    }

    @Override
    public String getEmoji() {
        return EMOJI_BOA_CONSTRICTOR;
    }
    @Override
    public int maxSpeed() {
        return BoaConstrictor.MOVE_SPEED;
    }
    @Override
    public float getMaxWeight() {
        return WEIGHT;
    }



}
