package lotto.service.reward;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(-5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final int rank;
    private final int reward;
    private final boolean bonus;

    Rank(int correct, int reward, boolean bonus) {
        this.rank = correct;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }



    public boolean isBonus() {
        return bonus;
    }

    public static int getReward(int rank) {
        Rank[] values = values();
        for (Rank r : values) {
            if (r.getRank() == rank) {
                return r.getReward();
            }
        }
        return 0;
    }
}
