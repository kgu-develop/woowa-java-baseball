package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CHARACTER_REGEX = "[-+]?\\d*\\.?\\d+";
    private static final String RESTART_STATUS = "1";
    private static final String NOT_RESTART_STATUS = "2";
    private static final String RESTART_OR_END_ONE_OR_TWO_EXCEPTION = "재시작은 1, 완전 종료는 2 입니다.";
    private static final String RESTART_OR_END_NOT_NUMBER_BECAUSE_STRING_EXCEPTION = "재시작은 1, 완전 종료는 2인 정수입니다.";
    private static final String RESTART_OR_END_NOT_NUMBER_BECAUSE_DOUBLE_EXCEPTION = "재시작은 1, 완전 종료는 2인 정수로 소수를 입력할 수 없습니다.";
    public static final String INPUT_NUMBER_SPECIAL_CHARACTER_EXCEPTION = "특수 문자는 입력할 수 없습니다.";

    public static List<Integer> inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        validateNotSpecialCharacterInUserNumber(inputNumber);

        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String terminateSignUserInput() {
        String inputRestartStatus = Console.readLine();
        validateRestartStatus(inputRestartStatus);
        return inputRestartStatus;
    }

    private static void validateNotSpecialCharacterInUserNumber(String inputNumber) {
        if (!Arrays.stream(inputNumber.split("")).allMatch(digit -> digit.matches(CHARACTER_REGEX))) {
            throw new IllegalArgumentException(INPUT_NUMBER_SPECIAL_CHARACTER_EXCEPTION);
        }
    }

    private static void validateRestartStatus(final String restartStatus) {
        validateNotStringRestartStatus(restartStatus);
        validateNotDoubleRestartStatus(restartStatus);
        validateRangeRestartStatus(restartStatus);
    }

    private static void validateRangeRestartStatus(final String restartStatus) {
        if (!restartStatus.equals(RESTART_STATUS) && !restartStatus.equals(NOT_RESTART_STATUS)) {
            throw new IllegalArgumentException(RESTART_OR_END_ONE_OR_TWO_EXCEPTION);
        }
    }

    private static void validateNotStringRestartStatus(final String restartStatus) {
        if (!(restartStatus != null && restartStatus.matches(CHARACTER_REGEX))) {
            throw new IllegalArgumentException(RESTART_OR_END_NOT_NUMBER_BECAUSE_STRING_EXCEPTION);
        }
    }

    private static void validateNotDoubleRestartStatus(final String restartStatus) {
        if (!restartStatus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(RESTART_OR_END_NOT_NUMBER_BECAUSE_DOUBLE_EXCEPTION);
        }
    }
}
