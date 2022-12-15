package bridge;

import bridge.validation.InputViewValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.ErrorConstant.ERROR_BLANK_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {


    @DisplayName("예외 처리 : 다리 생성이 올바르게 되는지 검증")
    @Test
    void checkInputBlankValidation() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeTestNumberGenerator(newArrayList(1, 0, 1)));
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "U");
    }
}