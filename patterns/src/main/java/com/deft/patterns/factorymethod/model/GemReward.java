package com.deft.patterns.factorymethod.model;

/**
 * @author Sergey Golitsyn
 * created on 31.07.2021
 */
public class GemReward implements GameItem {

    @Override
    public void open() {
        // todo add open business logic
        System.out.println("GemReward opened");
    }
}
