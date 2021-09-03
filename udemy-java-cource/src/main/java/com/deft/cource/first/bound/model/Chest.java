package com.deft.cource.first.bound.model;

/**
 * @author Sergey Golitsyn
 * created on 31.08.2021
 */
public class Chest extends GameItem {

    @Override
    public String toString() {
        return "Chest";
    }

    public String openChest() {
        return "Common chest reward";
    }
}
