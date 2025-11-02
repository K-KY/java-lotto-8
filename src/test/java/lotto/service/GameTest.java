package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("인수로 받은 숫자가 존재하는지 확인 : 존재함")
    public void existTest() {
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        assertThat(game.containsNumber(1)).isTrue();
    }

    @Test
    @DisplayName("인수로 받은 숫자가 존재하는지 확인 : 존재하지 않음")
    public void existTestFalse() {
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        assertThat(game.containsNumber(7)).isFalse();
    }

    @Test
    @DisplayName("맞춘 갯수만큼 반환")
    public void numberOfContains() {
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        assertThat(game.numberOfContains(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }
}