package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerTest {
    @Test
    void 플레이어이름이_5글자를넘어가면_예외가발생한다() {
        assertThatThrownBy(() -> new Player("minjae"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 플레이어이름이_빈값이면_예외가발생한다(String text) {
        assertThatThrownBy(() -> new Player(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어이름이_영문자가아니면_예외가발생한다() {
        assertThatThrownBy(() -> new Player("안녕1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
