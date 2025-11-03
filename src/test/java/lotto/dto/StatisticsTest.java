package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Statistics 클래스 테스트")
class StatisticsTest {

    @Test
    @DisplayName("존재하지 않는 키 조회 시 0 반환")
    void get_shouldReturnZero_whenKeyNotPresent() {
        Statistics statistics = new Statistics();

        int value = statistics.get(999);

        assertThat(value).isZero();
    }

    @Test
    @DisplayName("add 로 값 추가하면 get 이 해당 값을 반환")
    void add_shouldStoreValue_whenKeyIsNew() {
        Statistics statistics = new Statistics();

        statistics.add(3, 1);

        assertThat(statistics.get(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("add 를 여러번 호출하면 값이 누적된다")
    void add_shouldAccumulateValues_onMultipleAdds() {
        Statistics statistics = new Statistics();

        statistics.add(4, 1);
        statistics.add(4, 2);
        statistics.add(4, 3);

        assertThat(statistics.get(4)).isEqualTo(6); // 1+2+3 = 6
    }

    @Test
    @DisplayName("음수 키(예: -5) 도 정상 처리된다")
    void add_shouldHandleNegativeKeys() {
        Statistics statistics = new Statistics();

        statistics.add(-5, 0);
        statistics.add(-5, 2);

        assertThat(statistics.get(-5)).isEqualTo(2);
    }

    @Test
    @DisplayName("서로 다른 키는 독립적으로 관리된다")
    void differentKeys_shouldBeIndependent() {
        Statistics statistics = new Statistics();

        statistics.add(3, 1);
        statistics.add(5, 4);
        statistics.add(-5, 1);

        assertThat(statistics.get(3)).isEqualTo(1);
        assertThat(statistics.get(5)).isEqualTo(4);
        assertThat(statistics.get(-5)).isEqualTo(1);
    }
}
