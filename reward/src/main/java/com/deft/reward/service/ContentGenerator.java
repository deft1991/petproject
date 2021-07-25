package com.deft.reward.service;


/**
 * @author Sergey Golitsyn
 * created on 16.04.2021
 */
public interface ContentGenerator {

    /**
     * Should drop reward
     */
    boolean shouldDropReward(int chance);

    /**
     * Generate random count in interval
     */
    int generateCount(Integer from, Integer to, Integer count);

}
