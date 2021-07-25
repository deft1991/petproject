package com.deft.reward.service.impl;

import com.deft.reward.service.ContentGenerator;
import com.deft.reward.service.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Golitsyn
 * created on 16.04.2021
 */

@Service
@RequiredArgsConstructor
public class ContentGeneratorImpl implements ContentGenerator {

    private final RandomGenerator randomGenerator;

    @Override
    public boolean shouldDropReward(int chance) {
        return randomGenerator.shouldDropReward(chance);
    }

    @Override
    public int generateCount(Integer from, Integer to, Integer count) {
        if (count > 0) {
            return count;
        }
        return randomGenerator.generateCount(from, to);
    }

}
