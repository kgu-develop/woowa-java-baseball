package baseball.utils;

public class ExceptionConstants {
    public enum BaseballException {
        BASEBALL_IS_NOT_IN_RANGE("숫자는 1..9 범위만 허용합니다."),
        BASEBALL_SIZE_IS_NOT_FULFILL("숫자 야구 게임을 위해서 숫자 3개가 필요합니다."),
        BASEBALL_MUST_BE_UNIQUE("중복된 숫자는 허용하지 않습니다."),
        ;

        public final String message;

        BaseballException(final String message) {
            this.message = message;
        }
    }

    public enum GameProcessCommandException {
        INVALID_COMMAND("재시작[1] / 종료[2] 중 하나를 입력해주세요.");

        public final String message;

        GameProcessCommandException(final String message) {
            this.message = message;
        }
    }

    public enum InputException {
        INPUT_LENGTH_MUST_BE_ACCEPTABLE_FOR_BASEBALLS("띄어쓰기 없이 숫자 3개를 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("숫자를 입력해주세요.");

        public final String message;

        InputException(final String message) {
            this.message = message;
        }
    }
}
