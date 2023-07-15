package baseball.controller;

import baseball.model.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.model.GameProcessDecider.GAME_RESTART;
import static baseball.model.GameStatus.GAME_RUNNING;
import static baseball.model.GameStatus.GAME_TERMINATE;

public class GameController {
    private static GameStatus gameStatus;
    private Computer computer;
    private User user;

    public GameController() {
        computer = new Computer();
        gameStatus = GAME_RUNNING;
    }

    public void run() {
        // 게임 시작
        OutputView.printGameStart();

        while (gameStatus.isGameNotTerminated()) {
            // User - Baseball 입력
            readUserBaseballInput();

            // 게임 결과 확인
            Result result = judgeGameByReferee();
            OutputView.printGameResult(result);

            // 게임 클리어 확인
            checkGameClear(result);
        }
    }

    private void readUserBaseballInput() {
        List<Integer> userBaseballs = InputView.readUserBaseballs();
        user = new User(userBaseballs);
    }

    private Result judgeGameByReferee() {
        return Referee.judge(computer.getBaseballs(), user.getBaseballs());
    }

    private void checkGameClear(final Result result) {
        if (result.isGameClear()) {
            OutputView.printGameClear();
            determineGameRestartOrEnd();
        }
    }

    private void determineGameRestartOrEnd() {
        int userCommand = InputView.readUserRestartCommand();
        GameProcessDecider decider = GameProcessDecider.getDecider(userCommand);

        if (decider == GAME_RESTART) {
            computer = new Computer();
            gameStatus = GAME_RUNNING;
        } else {
            gameStatus = GAME_TERMINATE;
        }
    }
}
