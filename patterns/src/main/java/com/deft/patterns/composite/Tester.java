package com.deft.patterns.composite;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2021
 */
public class Tester {

    public static void main(String[] args) {
        GoldReward goldReward = new GoldReward();
        GemReward gemReward = new GemReward();
        ChestReward chestReward = new ChestReward();

        ChestReward smallChestReward = new ChestReward();
        smallChestReward.setRewards(List.of(gemReward, goldReward));

        chestReward.setRewards(List.of(goldReward, gemReward, smallChestReward));
        chestReward.rewardFor();
    }
}
