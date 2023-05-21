package plants;

import main.*;

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
    public int maxSpeed() {
        return Plants.MOVE_SPEED;
    }

    @Override
    public float getWeight() {
        return this.currentWeight;
    }

    @Override
    public float getMaxWeight() {

        System.out.println("Максимальный вес не ограничен растения ростут постоянно");
        return Float.MAX_VALUE;
    }

    @Override
    public void setWeight(float weight) {
        this.currentWeight = weight;

    }

    @Override
    synchronized public boolean death() {
        int positionFlorAndFauna = GenerateRandomFlorAndFauna.POSITION.get(this.getClass().getSimpleName());
        int positionOnArray = GamePlay.islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).indexOf(this);
        if(this.getCurrentWeight()<=0){
            GamePlay.islandLocationCells.get(x).get(y).arraysCell.get(positionFlorAndFauna).remove(positionOnArray);
            Statistic.setDeathStatisticEvent(this.getEmoji()+"-"+"\uD83D\uDC80");
            return true;
        }
        return false;

    }


    @Override
    public String getEmoji() {
        return EMOJI_PLANTS;
    }

    public void grow(){
        currentWeight = currentWeight + 0.5f;

    }

    @Override
    public String toString() {
        return getEmoji();
    }


}
