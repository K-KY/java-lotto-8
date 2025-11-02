package lotto.service;

import lotto.Lotto;

import java.util.List;

public class Game {
    private final List<Integer> numbers;

    public Game(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int numberOfContains(Lotto lotto) {
        return (int) numbers.stream().filter(lotto::contains).count();
    }
}
