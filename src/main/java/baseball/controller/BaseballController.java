package baseball.controller;

import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    public void terminateGame(User user) {
        if (isTerminate()) {
            user.terminate();
            System.out.println("완전 정료");
        } else {
            user.restart();
        }
    }
    public boolean isTerminate() {
        String restartStatus = Console.readLine();

        validateRangeRestartStatus(restartStatus);
        validateNotStringRestartStatus(restartStatus);
        validateNotStringRestartStatus(restartStatus);


        if(restartStatus.equals("2") ){
            return true;
        } else {
            return false;
        }
    }

    public void validateRangeRestartStatus(final String restartStatus) {
        if (Integer.parseInt(restartStatus) < 1 || Integer.parseInt(restartStatus) > 2) {
            throw new IllegalArgumentException("재시작은 1, 완전 종료는 2 입니다.");
        }
    }

    public void validateNotStringRestartStatus(final String restartStatus) {
        if ( !(restartStatus != null && restartStatus.matches("[-+]?\\d*\\.?\\d+")) ) {
            throw new IllegalArgumentException("재시작은 1, 완전 종료는 2인 정수입니다.");
        }
    }

    public void validateNotDoubleRestartStatus(final String restartStatus) {
        if (!restartStatus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("재시작은 1, 완전 종료는 2인 정수로 소수를 입력할 수 없습니다.");
        }
    }

    public void restartGame() {
        // 게임을 끝내지 않을 것이라는 신호를 줌
    }
}
