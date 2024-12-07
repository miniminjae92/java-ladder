package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.FixedLinkGenerator;
import util.RandomLinkGenerator;

public class LadderBoardTest {
    @ParameterizedTest
    @CsvSource({
            "2",
            "5",
            "10"
    })
    void 높이가_유효할때_정상_생성된다(int height) {
        PlayerGroup playerGroup = new PlayerGroup("pobi,honux,crong,jk");
        RandomLinkGenerator linkGenerator = new RandomLinkGenerator();
        LadderBoard ladderBoard = new LadderBoard(height, playerGroup, linkGenerator);

        assertThat(ladderBoard.getRounds().size()).isEqualTo(height);
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "0",
            "11"
    })
    void 높이가_유효하지않을때_예외가발생한다(int height) {
        PlayerGroup playerGroup = new PlayerGroup("pobi,honux,crong,jk");
        RandomLinkGenerator linkGenerator = new RandomLinkGenerator();

        assertThatThrownBy(() -> new LadderBoard(height, playerGroup, linkGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateResult_정상_결과_확인() {
        FixedLinkGenerator fixed = new FixedLinkGenerator(List.of(
                true, false, true,
                false, true, false,
                true, false, false,
                false, true, false,
                true, false, true
        ));
        PlayerGroup playerGroup = new PlayerGroup("pobi,honux,crong,jk");
        LadderBoard ladderBoard = new LadderBoard(5, playerGroup, fixed);

        int result0 = ladderBoard.calculateResult(0);
        assertThat(result0).isEqualTo(0);
        int result1 = ladderBoard.calculateResult(1);
        assertThat(result1).isEqualTo(3);
        int result2 = ladderBoard.calculateResult(2);
        assertThat(result2).isEqualTo(2);
        int result3 = ladderBoard.calculateResult(3);
        assertThat(result3).isEqualTo(1);

    }
}
