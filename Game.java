package SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    int size;
    int noOfPlayers;
    String difficulty;
    Board board;
    Printer p;
    Dice dice;
    PlayerManager pm;
    Queue<Player> q;
    GameStrategy gameStrategy;

    public Game(int size, int noOfPlayers, String difficulty, GameStrategy gameStrategy) {
        this.size = size;
        this.noOfPlayers = noOfPlayers;
        this.difficulty = difficulty;
        this.board = new Board(size * size);
        this.p = new Printer();
        this.dice = new Dice();
        this.pm = new PlayerManager(noOfPlayers);
        this.q = new LinkedList<>();
        this.gameStrategy = gameStrategy;
    }

    public void start() {
        board.start();
        pm.takeInput(this.q);
        Scanner sc = new Scanner(System.in);
        while (this.q.size() > 1) {
            Player player = this.q.poll();
            int totalRoll = 0;
            boolean rollAgain = true;

            while (rollAgain) {
                p.askForTurn(player.name);
                String input = sc.nextLine();
                if (input.equals("")) {
                    int roll = dice.rollDice();
                    p.printRoll(player.name, roll);
                    p.printSnakesAndLadders(board.getSnakes(), board.getLadders());
                    totalRoll += roll;
                    rollAgain = gameStrategy.rollAgain(player, roll);
                } else {
                    rollAgain = false;
                }
            }

            if (totalRoll > 0) {
                if (isValid(player, totalRoll)) {
                    player.position += totalRoll;
                    player.position = board.jump(player.position);
                    p.currentPosition(player.position);

                    if (player.position == size * size) {
                        p.printWinner(player.name);
                        continue;
                    }
                } else {
                    p.printInvalidMove(player.name);
                }
            }

            this.q.add(player);
        }
    }

    public boolean isValid(Player player, int roll) {
        return player.position + roll <= size * size;
    }
}
