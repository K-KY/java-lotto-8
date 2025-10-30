package lotto.service.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    private static final int DEFAULT_LOTTO_START = 1;
    private static final int DEFAULT_LOTTO_END = 45;

    private RandomNumberGenerator() {}

    public static List<Integer> generate(int count) {
        return Randoms.pickUniqueNumbersInRange(DEFAULT_LOTTO_START, DEFAULT_LOTTO_END, count);
    }
}
