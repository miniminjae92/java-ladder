package domain;

import util.LinkGenerator;

public class Link {
    private final boolean connection;

    public Link(boolean preConnection, LinkGenerator linkGenerator) {
        this.connection = determineConnection(preConnection, linkGenerator);
    }

    public boolean isConnection() {
        return connection;
    }

    private boolean determineConnection(boolean preConnection, LinkGenerator linkGenerator) {
        if (preConnection) {
            linkGenerator.generateLink();
            return false;
        }
        return linkGenerator.generateLink();
    }
}
