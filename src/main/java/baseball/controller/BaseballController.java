package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

import static baseball.view.InputView.inputNumber;
import static baseball.view.OutputView.*;

public class BaseballController {
    private static final String RESTART_STATUS = "1";
    private static final int THREE_STRIKE = 3;
    private static final boolean NOT_THREE_STRIKE = true;

    private User user;
    private Computer computer;
    private int strikeCount;
    private int ballCount;

    public BaseballController() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void run() {
        printGameStartMessage();
        do {
            computer = gameStart();
            playGame();
        } while (gameOver());
    }

    private Computer gameStart() {
        return new Computer();
    }

    private void playGame() {
        user = new User();

        while (NOT_THREE_STRIKE) {
            user.setNumber(inputNumber());
            strikeCount = getStrikeCount(user, computer);
            ballCount = getBallCount(user, computer);

            printGameResultMessage(strikeCount, ballCount);
            if (strikeCount == THREE_STRIKE) {
                break;
            }
        }
    }

    private boolean gameOver() {
        return !isTerminate(InputView.terminateSignUserInput());
    }

    private int getStrikeCount(final User user, final Computer computer) {
        List<Integer> computerRandomNumber = computer.getRandomNumber();
        List<Integer> userNumber = user.getNumber();

        return Stream.iterate(0, n -> n + 1).limit(computerRandomNumber.size())
                .filter(i -> computerRandomNumber.get(i) == userNumber.get(i))
                .reduce(0, (cnt, b) -> cnt + 1);
    }

    private int getBallCount(final User user, final Computer computer) {
        List<Integer> computerRandomNumber = computer.getRandomNumber();
        List<Integer> userNumber = user.getNumber();

        return Stream.iterate(1, n -> n + 1).limit(9)
                .filter(i -> computerRandomNumber.contains(i) && userNumber.contains(i))
                .filter(i -> computerRandomNumber.indexOf(i) != userNumber.indexOf(i))
                .reduce(0, (cnt, b) -> cnt + 1);
    }

    private boolean isTerminate(final String restartStatus) {
        if(restartStatus.equals(RESTART_STATUS)){
            return false;
        } else {
            return true;
        }
    }
}
