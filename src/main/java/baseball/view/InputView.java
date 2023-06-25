package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.utils.BaseballConstants.BASEBALL_SIZE;
import static baseball.utils.ExceptionConstants.InputException.INPUT_LENGTH_MUST_BE_ACCEPTABLE_FOR_BASEBALLS;
import static baseball.utils.ExceptionConstants.InputException.INPUT_MUST_BE_NUMERIC;

public class InputView {
    public static List<Integer> readUserBaseballInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();
        validateInputIsNumeric(userInput);
        validateInputLengthIsAcceptableForBaseballs(userInput);

        return convertUserInputToIntegerList(userInput);
    }

    private static List<Integer> convertUserInputToIntegerList(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readUserRestartCommandInput() {
        String userInput = Console.readLine();
        validateInputIsNumeric(userInput);

        return Integer.parseInt(userInput);
    }

    private static void validateInputLengthIsAcceptableForBaseballs(final String userInput) {
        if (userInput.length() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(INPUT_LENGTH_MUST_BE_ACCEPTABLE_FOR_BASEBALLS.message);
        }
    }

    private static void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }
}
