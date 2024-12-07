package util;

import java.util.List;

public class FixedLinkGenerator implements LinkGenerator {
    private final List<Boolean> pattern;
    private int index;

    public FixedLinkGenerator(List<Boolean> pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean generateLink() {
        boolean result = pattern.get(index);
        index++;
        return result;
    }
}
