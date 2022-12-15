package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.function.Supplier;

import static bridge.constant.BridgeConstant.FAIL;
import static bridge.constant.BridgeConstant.SUCCESS;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Bridge bridge;
    private BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void runProgram() {
        outputView.printStart();
        int bridgeSize = repeat(inputView::readBridgeSize);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        runGame();
    }

    private void runGame() {
        bridgeGame.initMove(bridge);

        while (bridgeGame.checkCanMove()) {
            String userMoving = repeat(inputView::readMoving);
            bridgeGame.move(userMoving);
            outputView.printMap(bridgeGame);
        }
        judgeGame();
    }

    private void judgeGame() {
        String gameResult = bridgeGame.judge();
        if (gameResult.equals(FAIL)) {
            String gameCommand = repeat(inputView::readGameCommand);
            checkRetry(gameCommand, gameResult);
        }
        if (gameResult.equals(SUCCESS)) {
            endGame(gameResult);
        }
    }

    private void checkRetry(String gameCommand, String gameResult) {
        if (bridgeGame.retry(gameCommand)) {
            runGame();
        }
        if (!bridgeGame.retry(gameCommand)) {
            endGame(gameResult);
        }
    }

    private void endGame(String gameResult) {
        outputView.printResult(bridgeGame,gameResult);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
