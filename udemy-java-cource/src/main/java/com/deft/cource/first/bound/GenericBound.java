package com.deft.cource.first.bound;

import com.deft.cource.first.bound.model.Chest;
import com.deft.cource.first.bound.model.GemChest;
import com.deft.cource.first.bound.model.GoldChest;

/**
 * @author Sergey Golitsyn
 * created on 31.08.2021
 */
public class GenericBound<T extends Chest> {

    public static void main(String[] args) {

//        GenericBound<GameItem> gameItem = new GenericBound<>(); // //ошибка
        GenericBound<Chest> chest = new GenericBound<>();
        GenericBound<GoldChest> goldChest = new GenericBound<>();
        GenericBound<GemChest> gemChest = new GenericBound<>();
    }
}
