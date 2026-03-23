package SnakeAndLadder;

public class EasyGameStrategy implements GameStrategy {
    public boolean rollAgain(Player player, int diceValue) {
        if (diceValue == 6) {
            return true;
        }
        return false;
    }
}
