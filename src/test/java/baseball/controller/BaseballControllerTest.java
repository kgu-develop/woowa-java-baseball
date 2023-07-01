package baseball.controller;

import baseball.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballControllerTest {
    @Test
    @DisplayName("재시작 검증 테스트")
    void ValidateRangeRestartStatusTest() {
        // given
        String restartStatus = "5";
        BaseballController controller = new BaseballController();

        // when


        // then
        assertThatThrownBy(() -> controller.validateRangeRestartStatus(restartStatus))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("재시작 검증 테스트")
    void ValidateNotStringRestartStatusTest() {
        // given
        String restartStatus = "*";
        BaseballController controller = new BaseballController();

        // when


        // then
        assertThatThrownBy(() -> controller.validateNotStringRestartStatus(restartStatus))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("재시작 검증 테스트")
    void validateNotDoubleRestartStatusTest() {
        // given
        String restartStatus = "1.2";
        BaseballController controller = new BaseballController();

        // when


        // then
        assertThatThrownBy(() -> controller.validateNotDoubleRestartStatus(restartStatus))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("사용자 입력에 따른 종료 테스트")
    void terminateTest() {
        // given
        String restartStatus = "1";
        BaseballController controller = new BaseballController();
        
        // when

        // then
        assertThat(controller.isTerminate(restartStatus)).isFalse();
    }
}