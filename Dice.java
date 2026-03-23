package SnakeAndLadder;

public class Dice {
    int num;

    public Dice() {
        this.num = 1;
    }

    public int rollDice() {
        this.num = (int) (Math.random() * 6 + 1);
        return this.num;
    }

}
