package com.deft.patterns;

import com.deft.patterns.abstractfactory.factory.EventFactory;
import com.deft.patterns.abstractfactory.gameitem.Chest;
import com.deft.patterns.abstractfactory.gameitem.Hero;
import com.deft.patterns.abstractfactory.gameitem.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 *
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 *
 */
public class Application {

    private Chest chest;
    private Unit unit;
    private Hero hero;

    Application(EventFactory factory){
        this.chest = factory.getChest();
        this.unit = factory.getUnit();
        this.hero = factory.getHero();
    }

    List<String> getSkinUrls(){
        return List.of(chest.getSkinURL(), unit.getSkinURL(), hero.getSkinURL());
    }

    Map<String, String> getNames(){
        Map<String, String> names = new HashMap<>();
        names.put("chest", chest.getName());
        names.put("unit", unit.getName());
        names.put("hero", hero.getName());
        return names;
    }
}
