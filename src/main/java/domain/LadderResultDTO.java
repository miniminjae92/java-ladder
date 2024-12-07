package domain;

import java.util.List;

public class LadderResultDTO {
    private final List<String> players;
    private final List<List<Boolean>> ladder;
    private final List<String> prizes;

    public LadderResultDTO(List<String> players, List<List<Boolean>> ladder, List<String> prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
