package SnakeAndLadder;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 2, "standard", new EasyGameStrategy());
        game.start();
    }
}
