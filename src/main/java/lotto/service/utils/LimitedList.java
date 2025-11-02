package lotto.service.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LimitedList<T> {
    private static final String LIMIT_EXCEEDED = "[ERROR] 허용량 초과";
    private static final String NO_DATA = "[ERROR] 데이터 없음";
    private static final String INDEX_OUT_OF_BOUNDS = "[ERROR] 인덱스가 범위를 초과 했습니다.";
    private final List<T> elements;
    private final int limit;

    public LimitedList(int limit) {
        this.limit = limit;
        elements = new ArrayList<>();
    }

    public void addElement(T element) throws IllegalArgumentException {
        if (elements.size() >= limit) {
            throw new IllegalArgumentException(LIMIT_EXCEEDED);
        }
        elements.add(element);
    }

    public T getElements(int index) throws IllegalArgumentException {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException(NO_DATA);
        }

        if (index >= elements.size()) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        }
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }

    public int limit() {
        return limit;
    }

    public List<T> getList() {
        return Collections.unmodifiableList(elements);
    }
}
