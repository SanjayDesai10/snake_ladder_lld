package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LadderGenerator implements IGenerator<Ladder> {
    int n;

    public LadderGenerator(int n) {
        this.n = n;
    }

    public Ladder generate(List<Snake> snakes, List<Ladder> ladders) {
        List<Integer> ans = generateAvailableTailValues(snakes, ladders);
        int tail = (int) (Math.random() * ans.size());
        tail = ans.get(tail);
        List<Integer> headValues = generateAvailableHeadValues(tail);
        int head = headValues.get((int) (Math.random() * headValues.size()));
        Ladder l = new Ladder(head, tail);
        ladders.add(l);
        return l;
    }

    public List<Integer> generateAvailableHeadValues(int tail) {
        List<Integer> ans = new ArrayList<>();
        int side = (int) Math.sqrt(n);
        int tailRow = (tail - 1) / side;
        for (int i = tail + 1; i <= n; i++) {
            int headRow = (i - 1) / side;
            if (headRow != tailRow) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> generateAvailableTailValues(List<Snake> snakes, List<Ladder> ladders) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < snakes.size(); i++) {
            set.add(snakes.get(i).head);
        }
        for (int i = 0; i < ladders.size(); i++) {
            set.add(ladders.get(i).tail);
        }

        int side = (int) Math.sqrt(n);
        int lastRowStart = n - side + 1;
        for (int i = 2; i < lastRowStart; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
