package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.BaseballConstants.*;

public class Computer {
    private final Baseballs baseballs;

    public Computer() {
        this.baseballs = generateRandomBaseballs();
    }

    private Baseballs generateRandomBaseballs() {
        List<Integer> baseballs = new ArrayList<>();

        while (baseballs.size() != BASEBALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL, MAX_BASEBALL);
            if (!baseballs.contains(randomNumber)) {
                baseballs.add(randomNumber);
            }
        }

        return new Baseballs(baseballs);
    }

    public List<Integer> getBaseballs() {
        return baseballs.getBaseballs();
    }
}
