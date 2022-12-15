package bridge.domain;


import java.util.List;

import static bridge.constant.BridgeConstant.BRIDGE_RESULT_CORRECT;
import static bridge.constant.BridgeConstant.BRIDGE_RESULT_WRONG;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public String judgeUserMove(int location,String userMoving) {
        if (bridge.get(location).equals(userMoving)) {
            return BRIDGE_RESULT_CORRECT;
        }
        return BRIDGE_RESULT_WRONG;
    }
}
