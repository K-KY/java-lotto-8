package lotto.service;

import lotto.dto.Statistics;
import lotto.service.utils.ListMap;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_COST = 1000;
    private static final int SECOND_REWARD = 5;
    private static final LottoService instance = new LottoService();
    private static final LottoPublisher lottoPublisher = LottoPublisher.getInstance();

    public static LottoService getInstance() {
        return instance;
    }

    public Ticket buyLotto(int money) {
        int order = money / LOTTO_COST;
        Ticket ticket = new Ticket(order);
        for (int i = 0; i < order; i++) {
            ticket.addGame(new Game(lottoPublisher.getNumbers()));
        }
        return ticket;
    }

    public Statistics calculateResult(ListMap<Integer, Game> sortedGames, int bonusBall) {
        Statistics statistics = new Statistics();
        for (int i = 3; i <= 6; i++) {
            if (i == SECOND_REWARD) {
                claimIfSecond(sortedGames, statistics, bonusBall);
            }
            claimReward(sortedGames, statistics, i);
        }
        return statistics;
    }

    private void claimIfSecond(ListMap<Integer, Game> sortedGames, Statistics statistics, int bonusBall) {
        List<Game> games = new ArrayList<>();
        if (sortedGames.hasKey(SECOND_REWARD)) {
            games = sortedGames.get(SECOND_REWARD);
        }
        int count = (int) getBonusBallCount(bonusBall, games);
        statistics.add(5, count);
        statistics.add(-5, games.size() - count);
    }

    private static long getBonusBallCount(int bonusBall, List<Game> games) {
        return games.stream()
                .filter(g -> g.containsNumber(bonusBall))
                .count();
    }


    private void claimReward(ListMap<Integer, Game> sortedGames, Statistics statistics, int i) {
        if (sortedGames.hasKey(i)) {
            List<Game> games = sortedGames.get(i);
            statistics.add(i, games.size());
        }
    }
}
