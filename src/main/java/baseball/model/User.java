package baseball.model;


import java.util.List;
import java.util.Set;

public class User {

    private static final String INPUT_NUMBER_LENGTH_NOT_THREE_EXCEPTION = "입력 숫자는 3자리입니다.";
    private static final String INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION = "입력 숫자는 1 ~ 9입니다.";
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;
    public static final String INPUT_NUMBER_DUPLICATE_EXCEPTION = "입력숫자의 각 자리는 중복될 수 없습니다.";

    public enum RestartStatus { RESTART, TERMINATE }

    private List<Integer> number;

    public void setNumber(List<Integer> number) {
        validateNumberSize(number);
        validateNumberRange(number);
        validateDuplicateDigit(number);
        this.number = number;
    }

    private void validateNumberSize(final List<Integer> number) {
        if (number.size() > NUMBER_SIZE || number.size() < NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_NOT_THREE_EXCEPTION);
        }
    }

    private void validateNumberRange(final List<Integer> number) {
        if (!number.stream().allMatch(digit -> digit >= MIN_DIGIT && digit <= MAX_DIGIT)) {
            throw new IllegalArgumentException(INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION);
        }
    }

    private void validateDuplicateDigit(final List<Integer> number) {
        if (Set.copyOf(number).size() != number.size()) {
            throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATE_EXCEPTION);
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
