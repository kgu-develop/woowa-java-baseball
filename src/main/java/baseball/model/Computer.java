package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> randomNumber;

    public Computer() {
        saveRandomNumberWithGameStart();
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void saveRandomNumberWithGameStart() {
        randomNumber = new ArrayList<>();
        Integer digit;

        while (checkLengthSmallThanThree()) {
            digit = getRandomDigit();
            if (!hasDuplicateDigitInRandomNumber(digit)) {
                randomNumber.add(digit);
            }
        }
    }

    public boolean checkLengthSmallThanThree() {
        if (randomNumber.size() < 3) {
            return true;
        }
        return false;
    }

    public Integer getRandomDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean hasDuplicateDigitInRandomNumber(Integer digit) {
        if (randomNumber.contains(digit)) {
            return true;
        }
        return false;
    }

    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }
}
