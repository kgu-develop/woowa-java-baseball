package baseball.model;


import java.util.List;

public class User {

    public static final String INPUT_NUMBER_LENGTH_NOT_TRHEE_EXCEPTION = "입력 숫자는 3자리입니다.";
    public static final String INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION = "입력 숫자는 3자리입니다.";

    public enum RestartStatus { RESTART, TERMINATE }

    private List<Integer> number;
    public RestartStatus restartStatus;

    public void setNumber(List<Integer> number) {
        validateNumber(number);
        this.number = number;
    }

    public void validateNumber(final List<Integer> number) {
        if (number.size() > 3 || number.size() < 3) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_NOT_TRHEE_EXCEPTION);
        }

        if (!number.stream().allMatch(digit -> digit >= 1 && digit <= 9)) {
            throw new IllegalArgumentException(INPUT_DIGIT_LENGTH_NOT_ONE_EXCEPTION);
        }
    }

    public void restart() {
        this.restartStatus = RestartStatus.RESTART;
    }

    public void terminate() {
        this.restartStatus = RestartStatus.TERMINATE;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public RestartStatus getRestartStatus() {
        return restartStatus;
    }
}
