package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRING_REGEX = "[-+]?\\d*\\.?\\d+";
    private static final String RESTART_OR_END_NUMBER_NOT_NUMBER_EXCEPTION = "재시작은 1, 완전 종료는 2인 정수입니다.";

    public static List<Integer> inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char digitNumber = inputNumber.charAt(i);
            String digitStringNumber = String.valueOf(digitNumber);

            validateNotStringRestartStatus(digitStringNumber);
            number.add(Integer.valueOf(digitStringNumber));
        }
        return number;
    }

    public static String terminateSignUserInput() {
        return Console.readLine();
    }

    private static void validateNotStringRestartStatus(final String restartStatus) {
        if (!(restartStatus != null && restartStatus.matches(STRING_REGEX))) {
            throw new IllegalArgumentException(RESTART_OR_END_NUMBER_NOT_NUMBER_EXCEPTION);
        }
    }
}
