package domain;

public class Prize {
    private String prizeName;

    public Prize(String prizeName) {
        this.prizeName = validatePrizeName(prizeName);
    }

    public String getPrizeName() {
        return prizeName;
    }

    private String validatePrizeName(String prizeName) {
        String prizeNameRegex = "^[a-zA-Z0-9가-힣]{1,5}$";

        if (prizeName == null || prizeName.isBlank()) {
            throw new IllegalArgumentException("Prize name cannot be null or empty");
        }

        if (!prizeName.matches(prizeNameRegex)) {
            throw new IllegalArgumentException("Prize name is invalid");
        }

        return prizeName;
    }
}
