package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PlayerGroup {
    private final List<Player> playerNames;

    public PlayerGroup(String playerNames) {
        this.playerNames = createPlayerGroup(playerNames);
    }

    public List<Player> getPlayerNames() {
        return playerNames;
    }

    public int getPlayerCount() {
        return playerNames.size();
    }

    public int findIndexByName(String targetName) {
        for (int i = 0; i < playerNames.size(); i++) {
            if (isContains(targetName)) {
                return i;
            }
        }
        return -1;
    }

    public Boolean isContains(String name) {
        if (playerNames.stream().anyMatch(p -> p.getName().equals(name))) {
            return true;
        }
        return false;
    }

    private List<Player> createPlayerGroup(String playerNames) {
        return validateGroup(playerNames).stream()
                .map(Player::new)
                .toList();
    }

    private List<String> validateGroup(String playerNames) {
        if (playerNames == null || playerNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        List<String> parsedPlayerNames = parsePlayerNames(playerNames);

        if (parsedPlayerNames.size() < 2 || parsedPlayerNames.size() > 10) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicates(parsedPlayerNames)) {
            throw new IllegalArgumentException();
        }
        return parsedPlayerNames;
    }

    private List<String> parsePlayerNames(String playerNames) {
        return Arrays.stream(playerNames.split(","))
                .map(String::trim)
                .toList();
    }

    private boolean hasDuplicates(List<String> playerNames) {
        return new HashSet<>(playerNames).size() != playerNames.size();
    }
}
