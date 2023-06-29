package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public String randomNumber;

    public Computer() {
//        saveRandomNumberWithGameStart();
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void saveRandomNumberWithGameStart() {
        randomNumber = "";
        String digit;

        while (checkLengthSmallThanThree()) {
            digit = getRandomDigitToString();
            if (!hasDuplicateDigitInRandomNumber(digit)) {
                randomNumber += digit;
            }
        }
    }

    public boolean checkLengthSmallThanThree() {
        if (randomNumber.length() < 3) {
            return true;
        }
        return false;
    }

    public String getRandomDigitToString() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9));
    }

    public boolean hasDuplicateDigitInRandomNumber(String digit) {
        if (randomNumber.contains(digit)) {
            return true;
        }
        return false;
    }
}
