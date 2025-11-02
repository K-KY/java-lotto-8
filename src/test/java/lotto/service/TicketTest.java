package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {

    @Test
    @DisplayName("새로운 로또를 추가")
    void addGames() {
        Ticket ticket = new Ticket(3);
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        ticket.addGame(game);

        assertThat(ticket.getGames()).contains(game);
    }

    @Test
    @DisplayName("새로운 로또를 구매한 로또 이상 추가 할 수 없음")
    void addGamesException() {
        Ticket ticket = new Ticket(1);
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        ticket.addGame(game);

        assertThatThrownBy(() -> ticket.addGame(game)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매한 갯수보다 많습니다.");
    }

    @Test
    @DisplayName("생성된 로또 리스트 반환")
    void getGames() {
        Ticket ticket = new Ticket(1);
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        ticket.addGame(game);

        assertThat(ticket.getGames()).isEqualTo(List.of(game));
    }

    @Test
    @DisplayName("적어도 5등 이상 당첨된 로또 반환")
    void filterValuableGameS() {
        Ticket ticket = new Ticket(3);
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        Game game2 = new Game(List.of(2, 2, 3, 4, 5, 7));
        Game game3 = new Game(List.of(7, 8, 9, 10, 11, 12));
        ticket.addGame(game);
        ticket.addGame(game2);
        ticket.addGame(game3);

        assertThat(ticket.filterValuable(new Lotto(List.of(1,2,3,4,5,6))).size()).isEqualTo(2);
    }

}