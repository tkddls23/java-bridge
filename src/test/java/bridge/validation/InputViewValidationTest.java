package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.ErrorConstant.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewValidationTest {

    @DisplayName("예외 처리 : 입력값이 숫자가 아닐때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","hello"," "})
    void checkNotValidDigitInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkInputValid(input))
                .withMessageStartingWith(ERROR_NON_INTEGER);
    }

    @DisplayName("예외 처리 : 값을 입력하지 않았을 때 에러 발생 검증")
    @Test
    void checkInputBlankValidation() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkInputValid(""))
                .withMessageStartingWith(ERROR_BLANK_INPUT);
    }

    @DisplayName("예외 처리 : 다리 길이가 지정 범위에 있는지 검증")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,21})
    void checkNotValidDigitInputValidation(int bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkBridgeSizeRange(bridgeSize))
                .withMessageStartingWith(ERROR_OUT_OF_RANGE);
    }

    @DisplayName("예외 처리 : 입력 받은 이동할 칸이 올바른지 검증")
    @ParameterizedTest
    @ValueSource(strings = {" ","","1","UD", "u"})
    void checkBridgeMovingValid(String bridgeMoving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.checkBridgeMovingValid(bridgeMoving))
                .withMessageStartingWith(ERROR_NOT_VALID_MOVING_COMMAND);
    }
}