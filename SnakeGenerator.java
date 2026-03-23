package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SnakeGenerator implements IGenerator<Snake> {
    int n;

    public SnakeGenerator(int n) {
        this.n = n;
    }

    public Snake generate(List<Snake> snakes, List<Ladder> ladders) {
        List<Integer> ans = generateAvailableHeadValues(snakes, ladders);
        int head = (int) (Math.random() * ans.size());
        head = ans.get(head);
        List<Integer> tailValues = generateAvailableTailValues(head);
        int tail = tailValues.get((int) (Math.random() * tailValues.size()));
        Snake s = new Snake(head, tail);
        snakes.add(s);
        return s;
    }

    public List<Integer> generateAvailableTailValues(int head) {
        List<Integer> ans = new ArrayList<>();
        int side = (int) Math.sqrt(n);
        int headRow = (head - 1) / side;
        for (int i = 1; i < head; i++) {
            int tailRow = (i - 1) / side;
            if (tailRow != headRow) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> generateAvailableHeadValues(List<Snake> snakes, List<Ladder> ladders) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < snakes.size(); i++) {
            set.add(snakes.get(i).head);
        }
        for (int i = 0; i < ladders.size(); i++) {
            set.add(ladders.get(i).tail);
        }

        int side = (int) Math.sqrt(n);
        for (int i = side + 1; i < n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
