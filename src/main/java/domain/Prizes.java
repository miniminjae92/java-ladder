package domain;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private final List<Prize> PrizeNames;

    public Prizes(PlayerGroup playerGroup, String PrizeNames) {
        this.PrizeNames = createPrize(playerGroup, PrizeNames);
    }

    public List<Prize> getPrizeNames() {
        return PrizeNames;
    }

    public int getPrizeIndex(Prize prize) {
        return PrizeNames.indexOf(prize);
    }

    private List<Prize> createPrize(PlayerGroup playerGroup, String PrizeNames) {
        return validate(playerGroup, PrizeNames).stream()
                .map(Prize::new)
                .toList();
    }

    private List<String> validate(PlayerGroup playerGroup, String PrizeNames) {
        if (PrizeNames == null || PrizeNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        List<String> parsedPrizeNames = parsePrizeNames(PrizeNames);

        if (parsedPrizeNames.size() != playerGroup.getPlayerCount()) {
            throw new IllegalArgumentException();
        }

        return parsedPrizeNames;
    }

    private List<String> parsePrizeNames(String PrizeNames) {
        return Arrays.stream(PrizeNames.split(","))
                .map(String::trim)
                .toList();
    }
}
