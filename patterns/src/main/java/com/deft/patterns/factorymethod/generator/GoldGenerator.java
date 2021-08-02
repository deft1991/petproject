package com.deft.patterns.factorymethod.generator;

import com.deft.patterns.factorymethod.model.GameItem;
import com.deft.patterns.factorymethod.model.GoldReward;

/**
 * @author Sergey Golitsyn
 * created on 31.07.2021
 */
public class GoldGenerator extends ItemGenerator{

    @Override
    public GameItem createItem() {
        return new GoldReward();
    }
}
