import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerGroup {
    private final List<Player> playerNames;

    public PlayerGroup(String playerNames) {
        this.playerNames = createPlayerGroup(playerNames);
    }

    public List<Player> getPlayerNames() {
        return playerNames;
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

        if (duplicateNameCheck(parsedPlayerNames)) {
            throw new IllegalArgumentException();
        }
        return parsedPlayerNames;
    }

    private List<String> parsePlayerNames(String playerNames) {
        return Arrays.stream(playerNames.split(","))
                .map(String::trim)
                .toList();
    }

    private boolean duplicateNameCheck(List<String> playerNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : playerNames) {
            if (!uniqueNames.add(name)) {
                return true;
            }
        }
        return false;
    }
}
