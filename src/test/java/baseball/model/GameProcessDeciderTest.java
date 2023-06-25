package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.model.GameProcessDecider.GAME_END;
import static baseball.model.GameProcessDecider.GAME_RESTART;
import static baseball.utils.ExceptionConstants.GameProcessCommandException.INVALID_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameProcessDeciderTest {
    @Test
    @DisplayName("재시작[1], 종료[2] 이외의 Command를 입력하면 예외가 발생한다")
    void throwExceptionByInvalidCommand() {
        assertThatThrownBy(() -> GameProcessDecider.getDecider(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMAND.message);
    }

    @Test
    @DisplayName("게임 재시작[1] Decider를 선택한다")
    void selectGameRestart() {
        // when
        GameProcessDecider decider = GameProcessDecider.getDecider(1);

        // then
        assertThat(decider).isEqualTo(GAME_RESTART);
    }

    @Test
    @DisplayName("게임 종료[2] Decider를 선택한다")
    void selectGameEnd() {
        // when
        GameProcessDecider decider = GameProcessDecider.getDecider(2);

        // then
        assertThat(decider).isEqualTo(GAME_END);
    }
}
