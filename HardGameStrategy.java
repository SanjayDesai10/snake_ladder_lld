package SnakeAndLadder;

public class HardGameStrategy implements GameStrategy {
    public boolean rollAgain(Player player, int roll) {
        if (roll == 6) {
            player.consecutiveSixes++;
            if (player.consecutiveSixes == 3) {
                player.consecutiveSixes = 0;
                return false;
            }
            return true;
        }
        player.consecutiveSixes = 0;
        return false;
    }
}
