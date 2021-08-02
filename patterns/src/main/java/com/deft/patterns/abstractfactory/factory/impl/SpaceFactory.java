package com.deft.patterns.abstractfactory.factory.impl;

import com.deft.patterns.abstractfactory.factory.EventFactory;
import com.deft.patterns.abstractfactory.gameitem.Chest;
import com.deft.patterns.abstractfactory.gameitem.Hero;
import com.deft.patterns.abstractfactory.gameitem.Unit;
import com.deft.patterns.abstractfactory.gameitem.impl.space.SpaceChest;
import com.deft.patterns.abstractfactory.gameitem.impl.space.SpaceHero;
import com.deft.patterns.abstractfactory.gameitem.impl.space.SpaceUnit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 *
 * Space event
 */
public class SpaceFactory implements EventFactory {

    @Override
    public Chest getChest() {
        return new SpaceChest();
    }

    @Override
    public Unit getUnit() {
        return new SpaceUnit();
    }

    @Override
    public Hero getHero() {
        return new SpaceHero();
    }
}
