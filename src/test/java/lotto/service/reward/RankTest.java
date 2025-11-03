package lotto.service.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rank Enum 테스트")
class RankTest {

    @Test
    @DisplayName("각 Rank의 rank, reward, bonus 값이 정상")
    void eachRankFieldValuesShouldBeCorrect() {
        assertThat(Rank.FIRST.getRank()).isEqualTo(6);
        assertThat(Rank.FIRST.getReward()).isEqualTo(2_000_000_000);
        assertThat(Rank.FIRST.isBonus()).isFalse();

        assertThat(Rank.SECOND.getRank()).isEqualTo(-5);
        assertThat(Rank.SECOND.getReward()).isEqualTo(30_000_000);
        assertThat(Rank.SECOND.isBonus()).isTrue();

        assertThat(Rank.THIRD.getRank()).isEqualTo(5);
        assertThat(Rank.THIRD.getReward()).isEqualTo(1_500_000);
        assertThat(Rank.THIRD.isBonus()).isFalse();

        assertThat(Rank.FOURTH.getRank()).isEqualTo(4);
        assertThat(Rank.FOURTH.getReward()).isEqualTo(50_000);
        assertThat(Rank.FOURTH.isBonus()).isFalse();

        assertThat(Rank.FIFTH.getRank()).isEqualTo(3);
        assertThat(Rank.FIFTH.getReward()).isEqualTo(5_000);
        assertThat(Rank.FIFTH.isBonus()).isFalse();
    }

    @Test
    @DisplayName("getReward(rank) 는 해당 rank 의 상금 반환")
    void getRewardShouldReturnCorrectReward() {
        assertThat(Rank.getReward(6)).isEqualTo(2_000_000_000);
        assertThat(Rank.getReward(-5)).isEqualTo(30_000_000);
        assertThat(Rank.getReward(5)).isEqualTo(1_500_000);
        assertThat(Rank.getReward(4)).isEqualTo(50_000);
        assertThat(Rank.getReward(3)).isEqualTo(5_000);
    }

    @Test
    @DisplayName("존재하지 않는 rank 인 경우 0 을 반환")
    void getRewardShouldReturnZeroWhenRankNotFound() {
        assertThat(Rank.getReward(2)).isZero();
        assertThat(Rank.getReward(999)).isZero();
        assertThat(Rank.getReward(-999)).isZero();
    }
}
