package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Snake> snakes;
    List<Ladder> ladders;
    int n;
    SnakeGenerator snakeGenerator;
    LadderGenerator ladderGenerator;
    Printer p;

    public Board(int n) {
        this.n = n;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.snakeGenerator = new SnakeGenerator(n);
        this.ladderGenerator = new LadderGenerator(n);
        this.p = new Printer();
    }

    public void start() {
        for (int i = 0; i * i < n - 1; i++) {
            this.snakeGenerator.generate(snakes, ladders);
        }
        for (int i = 0; i * i < n - 1; i++) {
            this.ladderGenerator.generate(snakes, ladders);
        }
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int jump(int currentPosition) {
        int jump = 1;
        while (jump == 1) {
            jump = 0;
            for (Snake s : snakes) {
                if (s.head == currentPosition) {
                    p.biitenBySnake(currentPosition);
                    currentPosition = s.tail;
                    jump = 1;
                    break;
                }
            }
            for (Ladder l : ladders) {
                if (l.tail == currentPosition) {
                    p.climbedByLadder(currentPosition);
                    currentPosition = l.head;
                    jump = 1;
                    break;
                }
            }
        }
        return currentPosition;
    }
}
