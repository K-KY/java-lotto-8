package lotto.service.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LimitedListTest {

    @Test
    @DisplayName("제한 리스트 데이터 추가")
    void addElementTest() {
        LimitedList<Integer> limitedList = new LimitedList<>(1);
        limitedList.addElement(1);

        assertThat(limitedList.getElements(0)).isEqualTo(1);
        assertThat(limitedList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("제한 리스트 용량 초과")
    void removeElementTest() {
        LimitedList<Integer> limitedList = new LimitedList<>(1);
        limitedList.addElement(1);
        assertThatThrownBy(() -> limitedList.addElement(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 허용량 초과");
    }

    @Test
    @DisplayName("인덱스가 사이즈를 초과한경우")
    void indexOverSize() {
        LimitedList<Integer> limitedList = new LimitedList<>(10);
        limitedList.addElement(1);
        assertThatThrownBy(() -> limitedList.getElements(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 인덱스가 범위를 초과 했습니다.");
    }

    @Test
    @DisplayName("리스트가 비어있음")
    void listEmpty() {
        LimitedList<Integer> limitedList = new LimitedList<>(10);
        assertThatThrownBy(() -> limitedList.getElements(0))
                .hasMessage("[ERROR] 데이터 없음");
    }


    @Test
    @DisplayName("리스트 사이즈 반환")
    void returnSize() {
        LimitedList<Integer> limitedList = new LimitedList<>(1);
        limitedList.addElement(1);
        assertThat(limitedList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("리스트 허용량 반환")
    void returnLimitSize() {
        LimitedList<Integer> limitedList = new LimitedList<>(1);
        limitedList.addElement(1);
        assertThat(limitedList.size()).isEqualTo(1);
    }
}