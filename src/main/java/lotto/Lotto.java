package lotto;

import lotto.service.Game;
import lotto.service.Ticket;
import lotto.service.utils.ListMap;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String LOTTO_LENGTH_EXCEPTION = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "[ERROR] 중복된 숫자는 허용되지 않습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_EXCEPTION);
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }

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
