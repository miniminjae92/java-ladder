package domain;

import java.util.ArrayList;
import java.util.List;
import util.LinkGenerator;

public class Round {
    private List<Link> links;

    public Round(int playerCount, LinkGenerator linkGenerator) {
        boolean preConnection = false;
        this.links = createLinks(playerCount, preConnection, linkGenerator);
    }

    public List<Link> getLinks() {
        return links;
    }

    public int move(int currentIndex) {
        if (currentIndex > 0 && links.get(currentIndex - 1).isConnection()) {
            return currentIndex - 1;
        }

        if (currentIndex < links.size() && links.get(currentIndex).isConnection()) {
            return currentIndex + 1;
        }

        return currentIndex;
    }

    private List<Link> createLinks(int playerCount, boolean preConnection, LinkGenerator linkGenerator) {
        List<Link> links = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            Link link = new Link(preConnection, linkGenerator);
            links.add(link);
            preConnection = link.isConnection();
        }

        return links;
    }
}
