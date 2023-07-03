package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameResultMessage(final int strikeCount, final int ballCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
            System.out.println(GAME_OVER_MESSAGE);
            System.out.println(GAME_RESTART_OR_END_MESSAGE);
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING_MESSAGE);
        } else if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
        } else if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + BALL_MESSAGE);
        } else {
            System.out.println(ballCount + BALL_MESSAGE + strikeCount + STRIKE_MESSAGE);
        }
    }
}
