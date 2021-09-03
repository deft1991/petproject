package com.deft.cource.first.wildcard;

import com.deft.cource.first.bound.model.Chest;
import com.deft.cource.first.bound.model.GameItem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 02.09.2021
 */
public class WildcardTwo {

    public static void main(String[] args) {

        List<GameItem> gameItems = new ArrayList<>();
        gameItems.add(new GameItem());
        printWild(gameItems);

        List<Chest> chests = new ArrayList<>();
        chests.add(new Chest());
        printWild(chests);
        printObj(chests);

        for (Chest chest : chests) {
            if (chest instanceof Chest) {
                System.out.println(chest.openChest());
            }
        }


        //        //левый тип данных
        List<String> stringList = new ArrayList<>();
        stringList.add("подкидыш");
        printWild(stringList);

        //Можно еще и так
        List voidList = new ArrayList<>();
        voidList.add(LocalTime.now());
        printWild(voidList);
        printObj(voidList);

    }

    //Unbounded Wildcards
    private static void printWild(List<?> list) {
//        list.add("внезапно добавленная строка"); //ошибка
        list.forEach(System.out::println);
    }

    private static void printObj(List list) {
        list.add("внезапно добавленная строка");
        list.forEach(System.out::println);
    }
}
