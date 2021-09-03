package com.deft.cource.first.bound.model;

/**
 * @author Sergey Golitsyn
 * created on 31.08.2021
 */
public class GoldChest extends Chest {

    @Override
    public String toString() {
        return "GoldChest";
    }

    @Override
    public String openChest() {
        return "Gold chest reward";
    }
}
