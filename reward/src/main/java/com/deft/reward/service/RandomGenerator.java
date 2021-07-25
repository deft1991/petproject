package com.deft.reward.service;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2021
 */
// todo maybe move to independent module
public interface RandomGenerator {

    /**
     * Should drop reward
     */
    boolean shouldDropReward(int chance);

    /**
     * Generate random count in interval
     */
    int generateCount(int from, int to);

}
