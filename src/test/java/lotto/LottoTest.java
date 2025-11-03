package lotto;

import lotto.service.Game;
import lotto.service.Ticket;
import lotto.service.utils.ListMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또가 번호를 포함하는지")
    void containsTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    @DisplayName("등수별로 분류된 로또 리턴")
    void sortedGames() {
        Ticket ticket = new Ticket(5);
        ticket.addGame(new Game(List.of(1, 2, 3, 4, 5, 6)));
        ticket.addGame(new Game(List.of(1, 2, 3, 4, 5, 6)));
        ticket.addGame(new Game(List.of(1, 2, 3, 4, 5, 6)));
        ticket.addGame(new Game(List.of(1, 2, 3, 4, 5, 6)));
        ticket.addGame(new Game(List.of(1, 2, 3, 4, 5, 9)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        ListMap<Integer, Game> integerGameListMap = lotto.checkTicket(ticket);

        assertThat(integerGameListMap.get(6).size()).isEqualTo(4);
        assertThat(integerGameListMap.get(5).size()).isEqualTo(1);
    }
}
