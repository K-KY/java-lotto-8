package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<Integer, Integer> statistics;

    public Statistics() {
        this.statistics = new HashMap<>();
    }

    public void add(int i, int size) {
        statistics.put(i, statistics.getOrDefault(i, 0) + size);
    }

    public int get(int i) {
        if (statistics.containsKey(i)) {
            return statistics.get(i);
        }
        return 0;
    }
}
