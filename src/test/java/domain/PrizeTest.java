package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PrizeTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 당첨항목은_공백일때_예외가발생한다(String text) {
        assertThatThrownBy(() -> new Prize(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨항목은_5글자가넘어가면_예외가발생한다() {
        assertThatThrownBy(() -> new Prize("500000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
