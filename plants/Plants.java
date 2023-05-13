package plants;

import main.Animal;
import main.FlorAndFauna;

public class Plants implements FlorAndFauna{
    //emoji
    public static final String EMOJI_PLANTS = "\uD83C\uDF3E";
    public static final Float WEIGHT = 1f;
    public static final Integer MAX_AMOUNT = 200;
    public static final Integer MOVE_SPEED = 0;
    public static final Float HOW_MANY_FOOD_NEEDS = 0f;
    //position
    private int x;
    private int y;
    private volatile Float currentWeight;

    public Plants(int x, int y) {
        this.x = x;
        this.y = y;
        this.currentWeight = WEIGHT;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }


    @Override
    public String getEmoji() {
        return EMOJI_PLANTS;
    }

    public void grow(){
        currentWeight = currentWeight + 1f;

    }


}
