package baseball.view;

import baseball.model.Result;

import static baseball.utils.BaseballConstants.BASEBALL_SIZE;

public class OutputView {
    private static final String ENTER = "\n";
    private static final String SPACE = " ";

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameResult(final Result result) {
        System.out.println(refineGameResult(result));
    }

    private static String refineGameResult(final Result result) {
        if (!hasStrikeCount(result) && !hasBallCount(result)) {
            return NOTHING;
        }

        StringBuilder resultFormat = new StringBuilder();

        if (hasBallCount(result)) {
            resultFormat.append(result.getBallCount())
                    .append(BALL)
                    .append(SPACE);
        }

        if (hasStrikeCount(result)) {
            resultFormat.append(result.getStrikeCount())
                    .append(STRIKE);
        }

        return resultFormat.toString();
    }

    private static boolean hasBallCount(final Result result) {
        return result.getBallCount() > 0;
    }

    private static boolean hasStrikeCount(final Result result) {
        return result.getStrikeCount() > 0;
    }

    public static void printGameClear() {
        System.out.printf(
                "%d개의 숫자를 모두 맞히셨습니다! 게임 종료" + ENTER
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + ENTER,
                BASEBALL_SIZE
        );
    }
}
