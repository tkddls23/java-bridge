package bridge.validation;

import java.util.Objects;

import static bridge.constant.ErrorConstant.ERROR_BLANK_INPUT;

public class InputViewValidation {

    public static void checkInputBlank(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }
}
