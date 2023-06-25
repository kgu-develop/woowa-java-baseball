package baseball.model;

import java.util.Collections;
import java.util.List;

import static baseball.utils.BaseballConstants.*;
import static baseball.utils.ExceptionConstants.BaseballException.*;

public class Baseballs {
    private final List<Integer> baseballs;

    public Baseballs(final List<Integer> baseballs) {
        validateEachBaseballElementIsInRange(baseballs);
        validateTotalBaseballSize(baseballs);
        validateBaseballHasDuplicateNumber(baseballs);
        this.baseballs = baseballs;
    }

    private void validateEachBaseballElementIsInRange(final List<Integer> baseballs) {
        if (hasOutOfRange(baseballs)) {
            throw new IllegalArgumentException(BASEBALL_IS_NOT_IN_RANGE.message);
        }
    }

    private boolean hasOutOfRange(final List<Integer> baseballs) {
        return baseballs.stream()
                .anyMatch(baseball -> baseball < MIN_BASEBALL || baseball > MAX_BASEBALL);
    }

    private void validateTotalBaseballSize(final List<Integer> baseballs) {
        if (baseballs.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(BASEBALL_SIZE_IS_NOT_FULFILL.message);
        }
    }

    private void validateBaseballHasDuplicateNumber(final List<Integer> baseballs) {
        if (hasDuplicateNumber(baseballs)) {
            throw new IllegalArgumentException(BASEBALL_MUST_BE_UNIQUE.message);
        }
    }

    private boolean hasDuplicateNumber(final List<Integer> baseballs) {
        return baseballs.stream()
                .distinct()
                .count() != BASEBALL_SIZE;
    }

    public List<Integer> getBaseballs() {
        return Collections.unmodifiableList(baseballs);
    }
}
