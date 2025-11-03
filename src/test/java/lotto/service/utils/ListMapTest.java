package lotto.service.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListMapTest {


    @Test
    @DisplayName("데이터를 넣는다")
    void add() {
        ListMap<Integer, String> map = new ListMap<>();
        assertThatCode(() -> map.add(1, "String")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("넣은 값은 리스트로 저장된다")
    void get() {
        ListMap<Integer, String> map = new ListMap<>();
        map.add(1, "one");
        map.add(1, "일");

        assertThat(map.get(1)).isEqualTo(List.of("one", "일"));
        assertThat(map.get(1)).isInstanceOf(List.class);
    }

    @Test
    @DisplayName("조회하려는 키가 없으면 예외")
    void keyNotFound() {
        ListMap<Integer, String> map = new ListMap<>();
        assertThatThrownBy(() -> map.get(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당하는 키를 찾을 수 없습니다.");
    }

}