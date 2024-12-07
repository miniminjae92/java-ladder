package view;

import domain.LadderResultDTO;
import java.util.Map;

public class OutputView {

    public void printLadderResult(LadderResultDTO dto) {
        System.out.println("사다리 결과");
        System.out.println();

        dto.getPlayers().forEach(player -> System.out.printf("%-6s", player));
        System.out.println();

        dto.getLadder().forEach(row -> {
            row.forEach(link -> System.out.printf("%-6s", "|" + formatLink(link)));
            System.out.println("|");
        });

        dto.getPrizes().forEach(prize -> System.out.printf("%-6s", prize));
        System.out.println();
    }

    private String formatLink(Boolean isConnection) {
        if (isConnection) {
            return formatConnectedLink();
        }
        return formatDisconnectedLink();
    }

    private String formatConnectedLink() {
        return "------";
    }

    private String formatDisconnectedLink() {
        return "      ";
    }

    public void printSingleResult(String targetResult) {
        System.out.println("실행 결과");
        System.out.println(targetResult);
    }

    public void printTotalResult(Map<String, String> totalNameResult) {
        System.out.println("실행 결과");

        totalNameResult.forEach((key, value) -> System.out.printf("%-6s : %-6s%n", key, value));
    }
}
