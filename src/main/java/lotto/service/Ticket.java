package lotto.service;

import lotto.Lotto;
import lotto.service.utils.LimitedList;

import java.util.List;
import java.util.StringJoiner;

public class Ticket {
    private static final String GREATER_THAN_ORDER = "[ERROR] 구매한 갯수보다 많습니다. 갯수 : ";
    private static final int MINIMUM_PRIZE = 3;
    private final LimitedList<Game> games;

    public Ticket(int order) {
        games = new LimitedList<>(order);
    }

    public void addGame(Game game) {

        try {
            games.addElement(game);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(GREATER_THAN_ORDER + games.limit(), e);
        }
    }

    public List<Game> getGames() {
        return games.getList();
    }


    public List<Game> filterValuable(Lotto lotto) {
        return getGames().stream()
                .filter(g -> g.numberOfContains(lotto) >= MINIMUM_PRIZE)
                .toList();
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Game game : getGames()) {
            joiner.add(game.toString());
        }
        return joiner.toString();
    }
}
