package lotto.service;

import lotto.service.generator.RandomNumberGenerator;

import java.util.List;

public class LottoPublisher {
    private static final int DEFAULT_LOTTO_COUNT = 6;
    private static LottoPublisher lottoPublisher;

    private LottoPublisher() {}

    public static LottoPublisher getInstance() {
        if (lottoPublisher == null) {
            lottoPublisher = new LottoPublisher();
        }
        return lottoPublisher;
    }

    public List<Integer> getNumbers() {
        return RandomNumberGenerator.generate(DEFAULT_LOTTO_COUNT);
    }

    public List<Integer> getNumbers(int count) {
        return RandomNumberGenerator.generate(count);
    }
}
