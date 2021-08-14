package com.deft.patterns.composite;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2021
 */

public abstract class BaseReward implements RewardItem {

    private final String type;

    BaseReward(String type){
        this.type = type;
    }

    public abstract List<?> rewardFor();

    public String getType() {
        return type;
    }
}
