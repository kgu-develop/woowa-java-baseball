package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RefereeTest {
    @ParameterizedTest
    @MethodSource("dummyBaseballs")
    @DisplayName("Referee가 Computer & User 간 숫자 야구 게임 결과(Result)를 도출한다")
    void judge(
            List<Integer> computerBaseballs,
            List<Integer> userBaseballs,
            int strikeCount,
            int ballCount
    ) {
        // when
        Result result = Referee.judge(computerBaseballs, userBaseballs);

        // then
        assertAll(
                () -> assertThat(result.getStrikeCount()).isEqualTo(strikeCount),
                () -> assertThat(result.getBallCount()).isEqualTo(ballCount)
        );
    }

    private static Stream<Arguments> dummyBaseballs() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 6),
                        0,
                        0
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 1),
                        0,
                        1
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(2, 1, 5),
                        0,
                        2
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(3, 1, 2),
                        0,
                        3
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(1, 4, 5),
                        1,
                        0
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(1, 2, 5),
                        2,
                        0
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(1, 2, 3),
                        3,
                        0
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 5),
                        1,
                        1
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        1,
                        2
                )
        );
    }

    @Test
    @DisplayName("Game Clear(All Strike) 여부를 확인한다")
    void isGameClear() {
        // given
        final List<Integer> computerBaseballs = List.of(1, 2, 3);
        final List<Integer> userBaseballs1 = List.of(1, 2, 3);
        final List<Integer> userBaseballs2 = List.of(1, 2, 4);

        // when
        Result result1 = Referee.judge(computerBaseballs, userBaseballs1);
        Result result2 = Referee.judge(computerBaseballs, userBaseballs2);

        // then
        assertAll(
                () -> assertThat(result1.isGameClear()).isTrue(),
                () -> assertThat(result2.isGameClear()).isFalse()
        );
    }
}
