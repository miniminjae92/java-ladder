import java.lang.invoke.StringConcatFactory;
import java.security.PublicKey;

public class Player {
    private final String NAMEREGEX = "^[a-zA-Z]{1,5}$";
    private final String name;

    public Player(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!name.matches(NAMEREGEX)) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}
