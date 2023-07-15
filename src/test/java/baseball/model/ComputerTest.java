package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerTest {
    @Test
    @DisplayName("Baseballs 랜덤 제공을 통해서 Computer를 생성한다")
    void construct() {
        // when
        final Computer computer = new Computer();

        // then
        assertAll(
                () -> assertThat(computer.getBaseballs()).hasSize(3), // size
                () -> assertThat(
                        computer.getBaseballs()
                                .stream()
                                .distinct()
                                .count()
                ).isEqualTo(3) // has duplicate
        );
    }
}
