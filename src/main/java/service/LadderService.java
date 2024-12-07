package service;

import domain.LadderBoard;
import domain.LadderResultDTO;
import domain.Link;
import domain.Player;
import domain.PlayerGroup;
import domain.Prize;
import domain.Prizes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderService {

    public Map<Integer, Integer> calculateResults(LadderBoard ladderBoard, PlayerGroup playerGroup) {
        Map<Integer, Integer> resultPlayerIndex = new HashMap<>();
        for (int startIndex = 0; startIndex < playerGroup.getPlayerCount(); startIndex++) {
            resultPlayerIndex.put(startIndex, ladderBoard.calculateResult(startIndex));
        }
        return resultPlayerIndex;
    }

    public Map<String, String> createPlayerToPrizeMap(Map<Integer, Integer> resultPlayerIndex, List<String> playerNames,
                                                      List<String> prizeNames) {
        Map<String, String> indexToNames = new HashMap<>();
        resultPlayerIndex.forEach((playerIndex, prizeIndex) ->
                indexToNames.put(playerNames.get(playerIndex), prizeNames.get(prizeIndex)));
        return indexToNames;
    }

    public LadderResultDTO createLadderResultDTO(PlayerGroup playerGroup, Prizes prizes, LadderBoard ladderBoard) {
        List<String> playerResult = playerGroup.getPlayerNames().stream().map(Player::getName).toList();
        List<String> prizeResult = prizes.getPrizeNames().stream().map(Prize::getPrizeName).toList();
        List<List<Boolean>> ladderResults = ladderBoard.getRounds().stream()
                .map(round -> round.getLinks().stream().map(Link::isConnection).toList())
                .toList();

        return new LadderResultDTO(playerResult, ladderResults, prizeResult);
    }
}
