package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import util.RandomLinkGenerator;

public class LinkTest {
    @Test
    void 연결선은_랜덤으로_생성한다() {
        boolean preCondition = false;
        Link link = new Link(preCondition, new RandomLinkGenerator());

        assertThat(link.isConnection()).isInstanceOf(Boolean.class);
    }
}
