package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.BaseballConstants.*;

public class Computer {
    private final Baseballs baseballs;

    public Computer() {
        this.baseballs = generateRandomBaseballs();
    }

    private Baseballs generateRandomBaseballs() {
        List<Integer> baseballs = new ArrayList<>();

        while (isNotReachedLimitSize(baseballs)) {
            int randomNumber = getRandomNumberInRange();
            if (isRandomNumberAbsentInBaseballs(baseballs, randomNumber)) {
                baseballs.add(randomNumber);
            }
        }

        return new Baseballs(baseballs);
    }

    private boolean isNotReachedLimitSize(final List<Integer> baseballs) {
        return baseballs.size() < BASEBALL_SIZE;
    }

    private int getRandomNumberInRange() {
        return Randoms.pickNumberInRange(MIN_BASEBALL, MAX_BASEBALL);
    }

    private boolean isRandomNumberAbsentInBaseballs(
            final List<Integer> baseballs,
            final int randomNumber
    ) {
        return !baseballs.contains(randomNumber);
    }

    public List<Integer> getBaseballs() {
        return baseballs.getBaseballs();
    }
}
