package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    @DisplayName("컴퓨터의 랜덤 수를 저장할 때 중복된 숫자를 가지지 않는지 테스트 ")
    void hasDigitTest() {
        // given
        Computer computer = new Computer();

        // when
        computer.randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        // then
        assertThat(computer.hasDuplicateDigitInRandomNumber(1)).isTrue();
    }

    @Test
    @DisplayName("한자리 랜덤 수 생성 테스트")
    void getRandomDigitTest() {
        // given
        Computer computer = new Computer();

        // when
        Integer randomDigit = computer.getRandomDigit();

        // then
        assertThat(randomDigit >= 1 && randomDigit <= 9).isTrue();
    }

    @Test
    @DisplayName("랜덤수가 3자리 이하인지 체크 테스트")
    void checkLengthTest() {
        // given
        Computer computer = new Computer();

        // when
        computer.randomNumber = new ArrayList<>(Arrays.asList(1, 2));

        // then
        assertThat(computer.checkLengthSmallThanThree()).isTrue();
    }

    @Test
    @DisplayName("랜덤 수 생성 테스트")
    void saveRandomNumberTest() {
        // given
        Computer computer = new Computer();

        // when
        computer.saveRandomNumberWithGameStart();
        List<Integer> randomNumber = computer.randomNumber;

        // then
        assertThat(randomNumber.stream().allMatch(digit -> digit >= 111 && digit <= 999));
        System.out.println(randomNumber);
    }
}