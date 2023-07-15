package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.utils.ExceptionConstants.BaseballException.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    @DisplayName("입력한 원소중에 1..9 범위가 아닌 원소가 있으면 User는 Baseballs를 가질 수 없다")
    void throwExceptionByBaseballIsNotInRange() {
        // given
        final List<Integer> baseballs = List.of(1, 9, 10);

        // when - then
        assertThatThrownBy(() -> new User(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_IS_NOT_IN_RANGE.message);
    }

    @Test
    @DisplayName("입력한 원소의 크기가 3이 아니면 User는 Baseballs를 가질 수 없다")
    void throwExceptionByBaseballSizeNotFulfill() {
        // given
        final List<Integer> baseballs = List.of(1, 2);

        // when - then
        assertThatThrownBy(() -> new User(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_SIZE_IS_NOT_FULFILL.message);
    }

    @Test
    @DisplayName("입력한 원소중에 중복된 원소가 존재한다면 User는 Baseballs를 가질 수 없다")
    void throwExceptionByBaseballIsNotUnique() {
        // given
        final List<Integer> baseballs = List.of(1, 2, 2);

        // when - then
        assertThatThrownBy(() -> new User(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_MUST_BE_UNIQUE.message);
    }

    @Test
    @DisplayName("User를 생성한다")
    void construct() {
        // given
        final List<Integer> baseballs = List.of(1, 2, 3);

        // when
        final User user = new User(baseballs);

        // then
        assertThat(user.getBaseballs()).containsExactlyElementsOf(baseballs);
    }
}
