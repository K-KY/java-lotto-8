package lotto;

import lotto.service.Game;
import lotto.service.Ticket;
import lotto.service.utils.ListMap;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public ListMap<Integer, Game> checkTicket(Ticket ticket) {
        List<Game> games = ticket.filterValuable(this);//당첨 최소 조건을 만족한 로또 추출

        ListMap<Integer, Game> sortedGames = new ListMap<>();

        for (Game game : games) {
            sortByRank(game, sortedGames);
        }
        return sortedGames;
    }

    private void sortByRank(Game game, ListMap<Integer, Game> sortedGames) {
        int count = (int) numbers.stream()
                .map(game::containsNumber)
                .filter(b -> b)
                .count();

        sortedGames.add(count, game);
    }
}
