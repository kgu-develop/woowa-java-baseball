package baseball.model;

import java.util.List;

public class User {
    private final Baseballs baseballs;

    public User(final List<Integer> baseballs) {
        this.baseballs = new Baseballs(baseballs);
    }

    public List<Integer> getBaseballs() {
        return baseballs.getBaseballs();
    }
}
