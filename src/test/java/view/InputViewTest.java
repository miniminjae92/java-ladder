package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 참여할_플레이어들의_이름을_입력한다() {
        String input = "pobi,honux,crong,jk";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String result = inputView.askPlayerNames();

        assertThat(result).isEqualTo("pobi,honux,crong,jk");
    }

    @Test
    void 실행_결과를_입력한다() {
        String input = "꽝,5000,꽝,3000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String result = inputView.askPrizeNames();

        assertThat(result).isEqualTo("꽝,5000,꽝,3000");
    }

    @Test
    void 최대_사다리_높이를_입력한다() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        int result = inputView.askLadderHeight();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 결과확인_대상을_입력한다() {
        String input = "pobi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();

        String result = inputView.askResultPlayer();

        assertThat(result).isEqualTo("pobi");
    }

    @Test
    void 존재하지않는_단일대상을_입력할경우_예외가발생한다() {

    }
}
