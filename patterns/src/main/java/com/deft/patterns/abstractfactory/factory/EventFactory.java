package com.deft.patterns.abstractfactory.factory;

import com.deft.patterns.abstractfactory.gameitem.Chest;
import com.deft.patterns.abstractfactory.gameitem.Hero;
import com.deft.patterns.abstractfactory.gameitem.Unit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public interface EventFactory {

    Chest getChest();
    Unit getUnit();
    Hero getHero();
}
