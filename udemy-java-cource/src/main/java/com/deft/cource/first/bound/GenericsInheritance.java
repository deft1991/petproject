package com.deft.cource.first.bound;

import com.deft.cource.first.bound.model.Chest;
import com.deft.cource.first.bound.model.GameItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 01.09.2021
 */
public class GenericsInheritance {

    public static void main(String[] args) {

        GameItem cat = new Chest();

        List<Chest> catList = new ArrayList<>();
        //List<Animal> animalList = catList; //ошибка
    }

}
