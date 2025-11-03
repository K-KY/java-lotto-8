package lotto.service.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap<T,Y> {
    private static final String KEY_NOT_FOUND = "[ERROR] 해당하는 키를 찾을 수 없습니다.";
    private final Map<T, List<Y>> store;

    public ListMap() {
        store = new HashMap<>();
    }

    public void add(T key, Y value) {
        List<Y> stored = store.getOrDefault(key, new ArrayList<>());
        stored.add(value);
        store.put(key, stored);
    }

    public List<Y> get(T key) {
        if (store.containsKey(key)) {
            return store.getOrDefault(key, new ArrayList<>());
        }
        throw new IllegalArgumentException(KEY_NOT_FOUND);
    }
}
