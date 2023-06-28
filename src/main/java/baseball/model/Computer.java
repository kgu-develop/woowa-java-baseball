package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String randomNumber;

    public Computer() {
        saveRandomNumberWithGameStart();
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    private void saveRandomNumberWithGameStart() {
        randomNumber = "";
        String digit;

        while (checkLengthSmallThanThree()) {
            digit = getRandomDigitToString();
            if (!hasDigitInRandomNumber(digit)) {
                randomNumber += digit;
            }
        }
    }

    private boolean checkLengthSmallThanThree() {
        if (randomNumber.length() < 3) {
            return true;
        }
        return false;
    }

    private String getRandomDigitToString() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9));
    }

    private boolean hasDigitInRandomNumber(String digit) {
        if (randomNumber.contains(digit)) {
            return true;
        }
        return false;
    }
}
