package lotto.service;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class Ticket {
    private static final String GREATER_THAN_ORDER = "[ERROR] 구매한 갯수보다 많습니다. 갯수 : ";
    private static final int MINIMUM_PRIZE = 3;
    private final Game[] games;
    private int head;

    public Ticket(int number) {
        games = new Game[number];
        head = 0;
    }

    public void addGame(Game game) {
        if (head >= games.length) {
            //이 경우 재시작이 아니라 그냥 넘어가도록 구현 해야함
            throw new IllegalArgumentException(GREATER_THAN_ORDER + games.length);
        }
        games[head++] = game;
    }

    public List<Game> getGames() {
        return Arrays.stream(games).toList();
    }


    public List<Game> filterValuable(Lotto lotto) {
        return getGames().stream()
                .filter(g -> g.numberOfContains(lotto) >= MINIMUM_PRIZE)
                .toList();
    }
}
