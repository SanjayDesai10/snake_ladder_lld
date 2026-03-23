package SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayerManager {
    int n;
    Printer p;

    public PlayerManager(int n) {
        this.n = n;
        this.p = new Printer();
    }

    public void takeInput(Queue<Player> q) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            this.p.takeInputFromPlayer(i);
            String name = sc.nextLine();
            Player player = new Player(name);
            q.add(player);
        }

    }
}
