package com.deft.patterns.factorymethod.generator;

import com.deft.patterns.factorymethod.model.GameItem;
import com.deft.patterns.factorymethod.model.GemReward;

/**
 * @author Sergey Golitsyn
 * created on 31.07.2021
 */
public class GemGenerator extends ItemGenerator{

    @Override
    public GameItem createItem() {
        return new GemReward();
    }
}
