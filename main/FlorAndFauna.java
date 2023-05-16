package main;

public interface FlorAndFauna {
    public String getEmoji();
    public void setX(int x);
    public void setY(int y);
    public int getX();
    public int getY();
    public int maxSpeed();
    public float getWeight();
    public float getMaxWeight();
    public void setWeight(float weight);
    public  boolean dead(IslandLocationCell[][] islandLocationCells);

}
