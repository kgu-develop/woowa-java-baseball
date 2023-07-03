package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.utils.ExceptionConstants.InputException.INPUT_MUST_BE_NUMERIC;
import static baseball.utils.ExceptionConstants.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;

public class InputView {
    public static List<Integer> readUserBaseballs() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);

        return convertUserInputToIntegerList(userInput);
    }

    private static void validateInputHasSpace(final String userInput) {
        if (hasSpace(userInput)) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }

    private static void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }

    private static boolean hasSpace(String userInput) {
        return userInput.chars()
                .anyMatch(Character::isWhitespace);
    }

    private static List<Integer> convertUserInputToIntegerList(final String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readUserRestartCommand() {
        String userInput = Console.readLine();
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);

        return Integer.parseInt(userInput);
    }
}
