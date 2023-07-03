package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int NUMBER_LENGTH = 3;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;
    private List<Integer> randomNumber;

    public Computer() {
        saveRandomNumberWithGameStart();
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    private void saveRandomNumberWithGameStart() {
        randomNumber = new ArrayList<>();
        Integer digit;

        while (checkLengthSmallThanThree()) {
            digit = getRandomDigit();
            if (!hasDuplicateDigitInRandomNumber(digit)) {
                randomNumber.add(digit);
            }
        }
    }

    private boolean checkLengthSmallThanThree() {
        if (randomNumber.size() < NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private Integer getRandomDigit() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    private boolean hasDuplicateDigitInRandomNumber(final Integer digit) {
        if (randomNumber.contains(digit)) {
            return true;
        }
        return false;
    }

    public void setRandomNumber(final List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }
}
