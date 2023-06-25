package baseball.utils;

public class ExceptionConstants {
    public enum BaseballException {
        BASEBALL_IS_NOT_IN_RANGE("숫자는 1..9 범위만 허용합니다."),
        BASEBALL_SIZE_IS_NOT_FULFILL("숫자 3개를 입력해주세요."),
        BASEBALL_MUST_BE_UNIQUE("중복된 숫자는 허용하지 않습니다."),
        ;

        public final String message;

        BaseballException(final String message) {
            this.message = message;
        }
    }
}
