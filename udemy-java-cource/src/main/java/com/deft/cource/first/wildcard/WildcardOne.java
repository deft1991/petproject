package com.deft.cource.first.wildcard;

import com.deft.cource.first.bound.model.Chest;
import com.deft.cource.first.bound.model.GameItem;
import com.deft.cource.first.bound.model.GemChest;
import com.deft.cource.first.bound.model.GoldChest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 02.09.2021
 */
public class WildcardOne {

    public static void main(String[] args) {

        List<GameItem> gameItems = new ArrayList<>();
        gameItems.add(new GameItem());

        print(gameItems);
        printWild(gameItems);

        List<Chest> chestList = new ArrayList<>();
        chestList.add(new Chest());
        chestList.add(new GoldChest());
        chestList.add(new GemChest());

        List<GoldChest> homeCatList = new ArrayList<>();

        printWild(homeCatList);

//        print(chestList); //Ошибка

        printWild(chestList);

    }

    private static void print(List<GameItem> gameItems) {
        gameItems.forEach(System.out::println);
    }

    private static void printWild(List<? extends GameItem> gameItems) {
        gameItems.forEach(System.out::println);
    }
}
