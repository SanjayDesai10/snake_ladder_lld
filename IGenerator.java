package SnakeAndLadder;

import java.util.List;

public interface IGenerator<T> {
    T generate(List<Snake> snakes, List<Ladder> ladders);
}
