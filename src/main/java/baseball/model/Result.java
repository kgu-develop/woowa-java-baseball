package baseball.model;

import static baseball.utils.BaseballConstants.BASEBALL_SIZE;

public class Result {
    private final int strikeCount;
    private final int ballCount;

    public Result(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isGameClear() {
        return strikeCount == BASEBALL_SIZE;
    }
}
