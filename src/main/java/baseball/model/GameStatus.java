package baseball.model;

public enum GameStatus {
    GAME_RUNNING,
    GAME_TERMINATE,
    ;

    public boolean isGameNotTerminated() {
        return this != GAME_TERMINATE;
    }
}
