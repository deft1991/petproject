package com.deft.patterns.factorymethod;

import com.deft.patterns.factorymethod.generator.GemGenerator;
import com.deft.patterns.factorymethod.generator.GoldGenerator;
import com.deft.patterns.factorymethod.generator.ItemGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Golitsyn
 * created on 31.07.2021
 */
public class Game {

    public static void main(String[] args) {
        Random random = ThreadLocalRandom.current();
        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new GemGenerator());
        generatorList.add(new GoldGenerator());

        for (int i = 0; i < 10; i ++){
            int idx = Math.abs(random.nextInt() % 2) == 0 ? 0 : 1;
            ItemGenerator itemGenerator = generatorList.get(idx);
            itemGenerator.openReward();
        }
    }
}
