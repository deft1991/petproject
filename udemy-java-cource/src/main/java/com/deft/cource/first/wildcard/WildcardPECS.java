package com.deft.cource.first.wildcard;

import com.deft.cource.first.bound.model.Chest;
import com.deft.cource.first.bound.model.GameItem;
import com.deft.cource.first.bound.model.GoldChest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 03.09.2021
 */
public class WildcardPECS {

    public static void main(String[] args) {

        List<GameItem> gameItems = new ArrayList<>();
        gameItems.add(new GameItem());
        //printProducer(gameItems); //ошибка
        printConsumer(gameItems);

        List<Chest> chests = new ArrayList<>();
        chests.add(new Chest());
        printProducer(chests);
        printConsumer(chests);

        List<GoldChest> goldChests = new ArrayList<>();
        goldChests.add(new GoldChest());
        printProducer(goldChests);
//        printConsumer(goldChests); //ошибка

    }

    private static void printProducer(List<? extends Chest> chests) {
//        chests.add(new Object()); //Ошибка
//        chests.add(new GameItem()); //Ошибка
//        chests.add(new Chest()) //Ошибка
//        chests.add(new GoldChest()); //Ошибка

        List<? extends Chest> chestList = Arrays.asList(new Chest(), new GoldChest());
//        chests.addAll(chestList); //Ошибка

        Chest chest = chests.get(0);
        chest.openChest();

        chests.forEach(System.out::println);
    }

    private static void printConsumer(List<? super Chest> chests) {
//        chests.add(new Object());// Ошибка
//        chests.add(new GameItem());// Ошибка
        chests.add(new Chest());
        chests.add(new GoldChest());


        Object item = chests.get(0);
        System.out.println("item from the list:" + item);

        chests.forEach(System.out::println);
    }

}
