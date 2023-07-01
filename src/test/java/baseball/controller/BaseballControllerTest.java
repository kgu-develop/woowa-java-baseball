package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.comparable;
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

    @Test
    @DisplayName("스트라이크 개수 세기 테스트")
    void getStrikeCountTest() {
        // given
        BaseballController controller = new BaseballController();
        Computer computer = new Computer();
        User user = new User();

        // when
        user.setNumber(List.of(1, 2, 3));
        computer.setRandomNumber(List.of(1, 4, 4));
        int strikeCount = controller.getStrikeCount(user, computer);

        // then
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 갯수 세기 테스트")
    void getBallCountTest() {
        // given
        BaseballController controller = new BaseballController();
        Computer computer = new Computer();
        User user = new User();

        // when
        user.setNumber(List.of(1, 2, 3));
        computer.setRandomNumber(List.of(4, 7, 5));
        int ballCount = controller.getBallCount(user, computer);

        // then
        assertThat(ballCount).isEqualTo(0);
    }
}