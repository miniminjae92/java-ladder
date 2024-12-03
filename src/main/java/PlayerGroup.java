import java.util.ArrayList;
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
        if (playerNames == null || playerNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        List<String> parsedPlayerNames = Arrays.asList(playerNames.split(","));

        if (parsedPlayerNames.size() < 2 || parsedPlayerNames.size() > 10) {
            throw new IllegalArgumentException();
        }

        List<Player> players = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();
        for (String name : parsedPlayerNames) {
            name = name.trim();
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException();
            }
            players.add(new Player(name));
        }

        return players;
    }
}
