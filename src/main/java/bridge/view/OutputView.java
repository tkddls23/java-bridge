package bridge.view;

import bridge.domain.BridgeGame;

import static bridge.constant.MessageConstant.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 문구를 출력한다.
     */
    public void printStart() {
        System.out.println(MESSAGE_OUTPUT_START);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {

        System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, bridgeGame.getUpperResults()));
        printBlank();

        System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, bridgeGame.getLowerResults()));
        printBlank();
        printBlank();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, String gameResult) {

        System.out.println(MESSAGE_OUTPUT_RESULT);
        System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, bridgeGame.getUpperResults()));
        printBlank();

        System.out.printf(MESSAGE_OUTPUT_BRACKET, String.join(MESSAGE_OUTPUT_WALL, bridgeGame.getLowerResults()));
        printBlank();
        printBlank();
        printSuccessOrNot(gameResult, bridgeGame.getTryCount());
    }

    private void printSuccessOrNot(String gameResult, int tryCount) {
        System.out.printf(MESSAGE_OUTPUT_SUCCESS_OR_NOT,gameResult);
        System.out.printf(MESSAGE_OUTPUT_TRY_COUNT,tryCount);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printBlank() {
        System.out.println();
    }
}
