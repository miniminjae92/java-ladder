package util;

import java.util.Random;

public class RandomLinkGenerator implements LinkGenerator {
    private final Random random = new Random();

    @Override
    public boolean generateLink() {
        return random.nextBoolean();
    }
}
