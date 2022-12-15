package bridge.validation;

import java.util.Objects;

import static bridge.constant.ErrorConstant.ERROR_BLANK_INPUT;
import static bridge.constant.ErrorConstant.ERROR_NON_INTEGER;

public class InputViewValidation {

    public static void checkInputValid(String input) {
        checkInputBlank(input);
        checkInputDigit(input);
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
