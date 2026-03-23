package SnakeAndLadder;

public class Player {
    String name;
    int position;
    int consecutiveSixes;

    Player(String name) {
        this.name = name;
        this.position = 1;
        this.consecutiveSixes = 0;
    }
}
