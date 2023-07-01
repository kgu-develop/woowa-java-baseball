package baseball.model;


import java.util.List;

public class User {
    public enum RestartStatus { RESTART, TERMINATE }

    private List<Integer> number;
    public RestartStatus restartStatus;

    public void setNumber(List<Integer> number) {
        validateNumber(number);
        this.number = number;
    }

    public void validateNumber(final List<Integer> number) {
        if (number.size() > 3 || number.size() < 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리입니다.");
        }

        if (!number.stream().allMatch(digit -> digit >= 1 && digit <= 9)) {
            throw new IllegalArgumentException("입력 숫자는 3자리입니다.");
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
}
