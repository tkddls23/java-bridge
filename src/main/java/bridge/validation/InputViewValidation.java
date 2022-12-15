package bridge.validation;

import java.util.Objects;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN_COMMAND;
import static bridge.constant.BridgeConstant.BRIDGE_UP_COMMAND;
import static bridge.constant.ErrorConstant.*;

public class InputViewValidation {

    public static void checkInputValid(String input) {
        checkInputBlank(input);
        checkInputDigit(input);
    }

    public static void checkBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void checkBridgeMovingValid(String bridgeMoving) {
        if (!bridgeMoving.equals(BRIDGE_UP_COMMAND) && !bridgeMoving.equals(BRIDGE_DOWN_COMMAND)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MOVING_COMMAND);
        }
    }

    private static void checkInputBlank(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }

    private static void checkInputDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(ERROR_NON_INTEGER);
        }
    }
}
