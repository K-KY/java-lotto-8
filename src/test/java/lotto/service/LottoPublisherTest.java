package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPublisherTest {

    @Test
    @DisplayName("싱글톤 객체를 반환")
    void getInstance() {
        LottoPublisher instance = LottoPublisher.getInstance();
        assertThat(instance).isEqualTo(LottoPublisher.getInstance());
    }

    @Test
    @DisplayName("인수가 없으면 기본 6개의 숫자 반횐")
    void getNumbers() {
        LottoPublisher instance = LottoPublisher.getInstance();

        assertThat(instance.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("인수가 있으면 인수 만큼의 숫자 반횐")
    void getNumbersHasParam() {
        LottoPublisher instance = LottoPublisher.getInstance();

        assertThat(instance.getNumbers(1).size()).isEqualTo(1);
    }
}