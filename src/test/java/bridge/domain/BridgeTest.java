package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("예외 처리 : 이동하려는 칸이 이동가능한지 판단하는 함수 검증")
    @Test
    void checkJudgeUserMoveValidation() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));
        List<String> userMovings = List.of("U", "U", "U", "U");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < userMovings.size(); i++) {
            result.add(bridge.judgeUserMove(i, userMovings.get(i)));
        }
        assertThat(result).isEqualTo(List.of("O","X","X","O"));
    }
}