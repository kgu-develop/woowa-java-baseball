package baseball.model;


import java.util.List;

public class User {

    private static final String INPUT_NUMBER_LENGTH_NOT_TRHEE_EXCEPTION = "입력 숫자는 3자리입니다.";
    private static final String INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION = "입력 숫자는 3자리입니다.";

    public enum RestartStatus { RESTART, TERMINATE }

    private List<Integer> number;

    public void setNumber(List<Integer> number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final List<Integer> number) {
        if (number.size() > 3 || number.size() < 3) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_NOT_TRHEE_EXCEPTION);
        }

        if (!number.stream().allMatch(digit -> digit >= 1 && digit <= 9)) {
            throw new IllegalArgumentException(INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION);
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
