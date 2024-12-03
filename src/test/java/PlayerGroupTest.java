import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerGroupTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 플레이어그룹_널또는비어있을경우_예외가발생한다(String text) {
        assertThatThrownBy(() -> new PlayerGroup(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_그룹의수가_한명일경우_예외가발생한다() {
        assertThatThrownBy(() -> new PlayerGroup("minsu"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "'yusub, minji', 2",
            "'a,b,c,d,e,f,g,h,i,j', 10"
    })
    void 플레이어_그룹의수가_정상일경우_생성된다(String playerNames, int expectedSize) {
        PlayerGroup playerGroup = new PlayerGroup(playerNames);

        assertThat(playerGroup.getPlayerNames().size()).isEqualTo(expectedSize);
    }

    @Test
    void 플레이어_그룹의수가_열명초과일경우_예외가발생한다() {
        String players = IntStream.rangeClosed(1, 11)
                .mapToObj(i -> "MJ" + i)
                .collect(Collectors.joining(", "));

        assertThatThrownBy(() -> new PlayerGroup(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어의수가_중복될경우_예외가발생한다() {
        String names = "MJ, MJ";

        assertThatThrownBy(() -> new PlayerGroup(names))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
