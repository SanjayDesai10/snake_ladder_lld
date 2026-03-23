package SnakeAndLadder;

import java.util.List;

public class Printer {

    public Printer() {
    }

    public void currentPosition(int num) {
        System.out.println(" your current position is " + num);
    }

    public void takeInputFromPlayer(int i) {
        System.out.println("Player No: " + i + "enter your name");
    }

    public void askForTurn(String name) {
        System.out.println(name + " press enter to roll the dice");
    }

    public void biitenBySnake(int num) {
        System.out.println("You got biiten by snake at position " + num);
    }

    public void climbedByLadder(int num) {
        System.out.println("You climbed by ladder at position " + num);
    }

    public void printRoll(String name, int roll) {
        System.out.println(name + " rolled a " + roll);
    }

    public void printWinner(String name) {
        System.out.println("Congratulations! " + name + " won the game!");
    }

    public void printInvalidMove(String name) {
        System.out.println(name + " cannot move, needs exact roll to reach the end!");
    }

    public void printSnakesAndLadders(List<Snake> snakes, List<Ladder> ladders) {
        System.out.println("--- Snakes ---");
        int count = 0;
        for (Snake s : snakes) {
            System.out.printf("S(%d->%d) ", s.head, s.tail);
            count++;
            if (count % 5 == 0) System.out.println();
        }
        if (count % 5 != 0) System.out.println();

        System.out.println("--- Ladders ---");
        count = 0;
        for (Ladder l : ladders) {
            System.out.printf("L(%d->%d) ", l.tail, l.head);
            count++;
            if (count % 5 == 0) System.out.println();
        }
        if (count % 5 != 0) System.out.println();
        System.out.println("----------------");
    }
}