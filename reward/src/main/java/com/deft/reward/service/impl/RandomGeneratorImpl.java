package com.deft.reward.service.impl;

import com.deft.reward.service.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2021
 */

@Service
@RequiredArgsConstructor
public class RandomGeneratorImpl implements RandomGenerator {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean shouldDropReward(int chance) {
        if (chance <= 0) {
            return false;
        }
        int randomChance = random.nextInt(100);
        return chance >= randomChance;
    }

    @Override
    public int generateCount(int from, int to) {
        return random.nextInt(from, to + 1); // inclusive
    }

}
