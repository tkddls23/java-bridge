package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.MessageConstant.MESSAGE_INPUT_BRIDGE_SIZE;
import static bridge.constant.MessageConstant.MESSAGE_INPUT_BRIDGE_STEP;

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
        InputViewValidation.isValidInput(input);
        int bridgeSize = Integer.parseInt(input);
        InputViewValidation.isValidRangeOfBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MESSAGE_INPUT_BRIDGE_STEP);
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
