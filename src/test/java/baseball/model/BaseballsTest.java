package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static baseball.utils.ExceptionConstants.BaseballException.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BaseballsTest {
    @ParameterizedTest
    @MethodSource("invalidRange")
    @DisplayName("1..9 범위가 아닌 숫자가 존재하면 Baseballs를 생성할 수 없다")
    void throwExceptionByBaseballIsNotInRange(List<Integer> baseballs) {
        assertThatThrownBy(() -> new Baseballs(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_IS_NOT_IN_RANGE.message);
    }

    private static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 9)),
                Arguments.of(List.of(1, 9, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidSize")
    @DisplayName("숫자가 3개 미만이면 Baseballs를 생성할 수 없다")
    void throwExceptionByBaseballSizeNotFulfill(List<Integer> baseballs) {
        assertThatThrownBy(() -> new Baseballs(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_SIZE_IS_NOT_FULFILL.message);
    }

    private static Stream<Arguments> invalidSize() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateNumber")
    @DisplayName("중복된 숫자가 존재하면 Baseballs를 생성할 수 없다")
    void throwExceptionByBaseballIsNotUnique(List<Integer> baseballs) {
        assertThatThrownBy(() -> new Baseballs(baseballs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_MUST_BE_UNIQUE.message);
    }

    private static Stream<Arguments> duplicateNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(3, 3, 3))
        );
    }

    @Test
    @DisplayName("Baseballs를 생성한다")
    void construct() {
        assertDoesNotThrow(() -> new Baseballs(List.of(1, 2, 3)));
    }
}
