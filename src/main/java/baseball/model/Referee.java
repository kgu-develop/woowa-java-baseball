package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.utils.BaseballConstants.BASEBALL_SIZE;

public class Referee {
    private Referee() {
    }

    public static Result judge(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        final int strikeCount = calculateStrikeCount(computerBaseballs, userBaseballs);
        final int ballCount = calculateBallCount(computerBaseballs, userBaseballs);

        return new Result(strikeCount, ballCount);
    }

    private static int calculateStrikeCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        return (int) IntStream.range(0, BASEBALL_SIZE)
                .filter(index -> computerBaseballs.get(index).equals(userBaseballs.get(index)))
                .count();
    }

    private static int calculateBallCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        return getContainedElementsCount(computerBaseballs, userBaseballs)
                - calculateStrikeCount(computerBaseballs, userBaseballs);
    }

    private static int getContainedElementsCount(
            final List<Integer> computerBaseballs,
            final List<Integer> userBaseballs
    ) {
        return (int) userBaseballs.stream()
                .filter(computerBaseballs::contains)
                .count();
    }
}
