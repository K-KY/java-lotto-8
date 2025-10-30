package lotto.service.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("6개의 숫자 생성")
    void generateTest() {
        List<Integer> generate = RandomNumberGenerator.generate(6);

        assertThat(generate.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("1 ~ 45 범위의 숫자 생성")
    void generateRangeTest() {
        List<Integer> generate = RandomNumberGenerator.generate(6);
        assertThat(generate).allMatch(x -> 1 <= x && x <= 45);
    }

    @Test
    @DisplayName("중복된 숫자 없음")
    void generateNotDuplicateTest() {
        List<Integer> generate = RandomNumberGenerator.generate(6);
        assertThat(generate.stream().distinct().count()).isEqualTo(6);
    }
}