package bridge.domain;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeConstant.*;
import static bridge.constant.BridgeConstant.BRIDGE_DOWN_COMMAND;

public class User {

    private int userLocation;
    private Bridge bridge;
    private List<String> userMovings;
    private List<String> upperResults = new ArrayList<>();
    private List<String> lowerResults = new ArrayList<>();

    public void move(String userMoving) {
        String moveResult = bridge.judgeUserMove(userLocation, userMoving);
        updateUserMove(moveResult,userMoving);
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
}
