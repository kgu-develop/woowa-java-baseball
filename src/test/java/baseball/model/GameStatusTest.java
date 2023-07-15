package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.model.GameStatus.GAME_RUNNING;
import static baseball.model.GameStatus.GAME_TERMINATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameStatusTest {
    @Test
    @DisplayName("GameStatus가 TERMINATED가 아닌지 확인한다")
    void isGameNotTerminated() {
        assertAll(
                () -> assertThat(GAME_RUNNING.isGameNotTerminated()).isTrue(),
                () -> assertThat(GAME_TERMINATE.isGameNotTerminated()).isFalse()
        );
    }
}
