package lotto.view;

import lotto.controller.LottoController;
import lotto.dto.Statistics;
import lotto.service.reward.Rank;

import java.util.List;

public class UserView {
    private static final LottoController controller = LottoController.getInstance();
    private static final int LOTTO_COST = 1000;
    private static final String PURCHASED = "개를 구매했습니다.";
    private static final String TOTAL_REVENUE = "총 수익률은 ";
    private static final String TOTAL_REVENUE_SUFFIX = "%입니다.";
    private static final String CONTAINS_BONUS_BALLS = "개 일치, 보너스 볼 일치";
    private static final String CONTAINS_NUMBERS = "개 일치";
    private static UserView instance;

    public static UserView getInstance() {
        if (instance == null) {
            instance = new UserView();
        }
        return instance;
    }

    public void inputPurchaseInfo() {
        int money = Input.money();
        List<Integer> lotto = Input.lotto();
        int bonusBall = Input.bonusBall(lotto);
        Output.printMessage(money / LOTTO_COST + PURCHASED);

        Statistics statistics = controller.buyLotto(money, lotto, bonusBall);

        printResult(statistics);
        double v = calculateProfitRate(statistics, money);

        System.out.println(TOTAL_REVENUE + v + TOTAL_REVENUE_SUFFIX);

    }

    private void printResult(Statistics statistics) {
        for (int i = 3; i <= 6; i++) {
            printMatch(statistics, i, i+ CONTAINS_NUMBERS);
            if (i == 5) {
                printMatch(statistics, -i, i+ CONTAINS_BONUS_BALLS);
            }
        }
    }

    private void printMatch(Statistics statistics, int key, String description) {
        int count = statistics.get(key);
        int prize = Rank.getReward(key);
        System.out.printf("%s (%s원) - %d개%n", description, java.lang.String.format("%,d", prize), count);
    }

    public static long calculateTotalPrize(Statistics statistics) {
        long total = 0L;
        for (Rank r : Rank.values()) {
            int key = r.isBonus() ? -r.getRank() : r.getRank();
            int count = statistics.get(key);
            total += (long) r.getReward() * count;
        }
        return total;
    }


    private static double calculateProfitRate(Statistics statistics, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(statistics);
        return (double) totalPrize / purchaseAmount * 100.0;
    }

}
