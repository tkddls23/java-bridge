package bridge;

import bridge.domain.Bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeConstant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int userLocation;
    private Bridge bridge;
    private Boolean moveStatus;
    private List<String> userMovings;
    private List<String> upperResults;
    private List<String> lowerResults;
    private int tryCount = 0;

    public void initMove(Bridge bridge) {
        this.bridge = bridge;
        this.userMovings = new ArrayList<>();
        this.upperResults = new ArrayList<>();
        this.lowerResults = new ArrayList<>();
        this.moveStatus = true;
        this.tryCount ++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getUpperResults() {
        return upperResults;
    }

    public List<String> getLowerResults() {
        return lowerResults;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMoving) {
        String moveResult = bridge.judgeUserMove(userLocation, userMoving);
        updateUserMove(moveResult,userMoving);
        if (moveResult.equals(BRIDGE_RESULT_WRONG)) {
            moveStatus = false;
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
    private int updateUserLocation(String userMoving) {
        userMovings.add(userMoving);
        return userMovings.size()-1;
    }

    private void updateUserMove(String moveResult, String userMoving) {
        if (userMoving.equals(BRIDGE_UP_COMMAND)) {
            upperResults.add(moveResult);
            lowerResults.add(" ");
        }
        if (userMoving.equals(BRIDGE_DOWN_COMMAND)) {
            upperResults.add(" ");
            lowerResults.add(moveResult);
        }
    }

    public boolean checkCanMove() {
        if (isFinishedMove() || !moveStatus) {
            return false;
        }
        return true;
    }

    public String judge() {
        if (isFinishedMove()) {
            return SUCCESS;
        }
        return FAIL;
    }

    private boolean isFinishedMove() {
        if (userMovings.size() == bridge.getSize() && moveStatus) {
            return true;
        }
        return false;
    }
}
