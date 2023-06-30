package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("3자리가 아닌 입력 숫자 검증 기능 테스트")
    void validateNumberLengthTest() {
        // given
        User user = new User();

        // when
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(1, 2));

        // then
        assertThatThrownBy(() -> user.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3자리가 아닌 입력 숫자 검증 기능 테스트")
    void validateDigitLengthTest() {
        // given
        User user = new User();

        // when
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(1, 2, 33));

        // then
        assertThatThrownBy(() -> user.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("RestartStatus 테스트")
    void UserTest() {
        // given
        User user = new User();

        // when
        user.terminate();

        // then
        assertThat(user.restartStatus).isEqualTo(User.RestartStatus.RESTART);
    }
}