package controller;

import domain.LadderBoard;
import domain.LadderResultDTO;
import domain.Player;
import domain.PlayerGroup;
import domain.Prize;
import domain.Prizes;
import java.util.Map;
import service.LadderService;
import util.RandomLinkGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 1. 입력 받기
        String playerNames = inputView.askPlayerNames();
        PlayerGroup playerGroup = new PlayerGroup(playerNames);

        String prizeNames = inputView.askPrizeNames();
        Prizes prizes = new Prizes(playerGroup, prizeNames);

        int ladderHeight = inputView.askLadderHeight();
        LadderBoard ladderBoard = new LadderBoard(ladderHeight, playerGroup, new RandomLinkGenerator());

        // 2. 결과 계산
        Map<Integer, Integer> resultPlayerIndex = ladderService.calculateResults(ladderBoard, playerGroup);

        // 3. 플레이어-상품 매핑 생성
        Map<String, String> playerToPrizeMap = ladderService.createPlayerToPrizeMap(
                resultPlayerIndex,
                playerGroup.getPlayerNames().stream().map(Player::getName).toList(),
                prizes.getPrizeNames().stream().map(Prize::getPrizeName).toList()
        );

        // 4. LadderResultDTO 생성
        LadderResultDTO ladderResultDTO = ladderService.createLadderResultDTO(playerGroup, prizes, ladderBoard);

        // 5. 단일 결과 가져오기
        String targetName = inputView.askResultPlayer();
        String targetResult = playerToPrizeMap.getOrDefault(targetName, "결과 없음");

        // 6. 출력
        outputView.printLadderResult(ladderResultDTO);
        outputView.printSingleResult(targetResult);
        outputView.printTotalResult(playerToPrizeMap);
    }
}
