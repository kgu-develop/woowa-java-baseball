package baseball.model;

public class User {
    private enum RestartStatus { RESTART, TERMINATE }

    private String number;

    private void validateNumber(final String number) {
        if (number.length() > 3 || number.length() < 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리입니다.");
        }
    }
}
