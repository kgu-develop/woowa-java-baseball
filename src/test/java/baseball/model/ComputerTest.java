package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    @DisplayName("Baseballs 랜덤 제공을 통해서 Computer를 생성한다")
    void construct() {
        // when
        final Computer computer = new Computer();

        // then
        assertThat(computer.getBaseballs()).hasSize(3);
    }
}
