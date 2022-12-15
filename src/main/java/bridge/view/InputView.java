package bridge.view;

import bridge.validation.InputViewValidation;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.MessageConstant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MESSAGE_INPUT_BRIDGE_SIZE);

        String input = Console.readLine();
        InputViewValidation.checkInputValid(input);
        int bridgeSize = Integer.parseInt(input);
        InputViewValidation.checkBridgeSizeRange(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MESSAGE_INPUT_BRIDGE_STEP);
        String bridgeMoving = Console.readLine();
        InputViewValidation.checkBridgeMovingValid(bridgeMoving);
        return bridgeMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MESSAGE_INPUT_EXIT);
        String gameCommand = Console.readLine();
        InputViewValidation.checkGameCommandValid(gameCommand);
        return gameCommand;
    }
}
