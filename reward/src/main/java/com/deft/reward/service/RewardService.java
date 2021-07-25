package com.deft.reward.service;


import com.deft.reward.model.Profile;
import com.deft.reward.model.Reward;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2021
 */
public interface RewardService {

    /**
     * Claim reward by id. Collect reward list
     */
    // todo think about return type
    List<Object> claimReward(long rewardId);

    /**
     * Claim reward
     */
    List<Object> claimReward(Profile profile, Reward reward);

    /**
     * Claim rewards for profile
     */
    List<Object> claimReward(Profile profile, List<Reward> rewards);
}
