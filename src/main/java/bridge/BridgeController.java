package bridge;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.function.Supplier;

import static bridge.constant.BridgeConstant.FAIL;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void runProgram() {
        outputView.printStart();
        int bridgeSize = repeat(inputView::readBridgeSize);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        runGame();
    }

    public void runGame() {
        bridgeGame.initMove(bridge);

        while (bridgeGame.checkCanMove()) {
            String userMoving = repeat(inputView::readMoving);
            bridgeGame.move(userMoving);
        }
        endGame(bridgeGame);
    }

    private void endGame(BridgeGame bridgeGame) {
        String gameResult = bridgeGame.judge();
        if (gameResult.equals(FAIL)) {
            bridgeGame.retry();
        }
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
