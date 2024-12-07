package domain;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name) {
        String nameRegex = "^[a-zA-Z]{1,5}$";

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!name.matches(nameRegex)) {
            throw new IllegalArgumentException();
        }

        return name;
    }
}
