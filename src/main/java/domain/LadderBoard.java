package domain;

import java.util.ArrayList;
import java.util.List;
import util.LinkGenerator;

public class LadderBoard {
    private final List<Round> rounds;

    public LadderBoard(int height, PlayerGroup playerGroup, LinkGenerator linkGenerator) {
        this.rounds = createRounds(validateHeight(height), playerGroup.getPlayerCount(), linkGenerator);
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int calculateResult(int startIndex) {
        int currentIndex = startIndex;

        for (Round round : rounds) {
            currentIndex = round.move(currentIndex);
        }

        return currentIndex;
    }

    private int validateHeight(int height) {
        if (height < 2 || height > 10) {
            throw new IllegalArgumentException();
        }
        return height;
    }

    private List<Round> createRounds(int height, int userCount, LinkGenerator linkGenerator) {
        List<Round> rounds = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Round round = new Round(userCount, linkGenerator);
            rounds.add(round);
        }

        return rounds;
    }
}
