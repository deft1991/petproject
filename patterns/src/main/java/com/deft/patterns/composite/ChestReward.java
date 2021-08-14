package com.deft.patterns.composite;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2021
 */
public class ChestReward extends BaseReward {

    private List<BaseReward> rewards;

    ChestReward(){
        super("CHEST");
    }

    @Override
    public List<?> rewardFor() {
        System.out.println("rewardFor: " + this.getType());
        return rewards.stream().flatMap(reward -> reward.rewardFor().stream()).collect(Collectors.toList());
    }

    public void setRewards(List<BaseReward> rewards) {
        this.rewards = rewards;
    }
}
