package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PrizesTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 당첨항목_널또는비어있을경우_예외가발생한다(String text) {
        assertThatThrownBy(() -> new Prizes(new PlayerGroup("min, jae"), text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨항목_수가_하나일경우_예외가발생한다() {
        assertThatThrownBy(() -> new Prizes(new PlayerGroup("min, jae"), "꽝"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨항목의개수는_플레이어의수와_같다() {
        String playerNames = "pobi, min, yoso";
        String prizeNames = "꽝, 1000, 5000";
        PlayerGroup playerGroup = new PlayerGroup(playerNames);

        Prizes prizes = new Prizes(playerGroup, prizeNames);

        assertThat(prizes.getPrizeNames().size()).isEqualTo(playerGroup.getPlayerCount());
    }

    @Test
    void 당첨항목의개수는_플레이어의수와_틀리면_예외가_발생한다() {
        String playerNames = "pobi, min, yoso";
        String prizeNames = "꽝, 1000";
        PlayerGroup playerGroup = new PlayerGroup(playerNames);

        assertThatThrownBy(() -> new Prizes(playerGroup, prizeNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*
            - [] 위치에 알맞은 당첨 항목을 반환한다.
     */
    @Test
    void 당첨항목은_최대5글자가_넘으면_예외가발생한다() {
        assertThatThrownBy(() -> new Prizes(new PlayerGroup("a, b"), "123455, 123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치에_알맞은_당첨항목을_반환한다() {
        Prizes prizes = new Prizes(new PlayerGroup("a, b"), "1000, 꽝");

        assertThat(prizes.getPrizeIndex(prizes.getPrizeNames().get(0))).isEqualTo(0);
    }
}
