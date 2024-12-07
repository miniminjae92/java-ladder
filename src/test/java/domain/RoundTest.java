package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import util.RandomLinkGenerator;

public class RoundTest {
    @Test
    void 유저의수를_사용하여_링크객체리스트를_생성한다() {
        int users = 10;
        Round round = new Round(users, new RandomLinkGenerator());

        assertThat(round.getLinks().size()).isEqualTo(users - 1);
    }
}
