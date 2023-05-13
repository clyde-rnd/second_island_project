package main;

public abstract class Animal implements FlorAndFauna {

    //position
    private int x;
    private int y;
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

    public void eat(FlorAndFauna florAndFauna){
        System.out.println("I'm eat");
    }
    public void reproduction(){
        System.out.println("I'm reproduction");
    }
    public void move(){
        System.out.println("I'm move");
    }

    public void beEaten(){
        System.out.println("BeEaten");
    }
    public void Dead(){
        System.out.println("This person dead");
    }

}
