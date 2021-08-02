package com.deft.patterns.abstractfactory.factory.impl;

import com.deft.patterns.abstractfactory.factory.EventFactory;
import com.deft.patterns.abstractfactory.gameitem.Chest;
import com.deft.patterns.abstractfactory.gameitem.Hero;
import com.deft.patterns.abstractfactory.gameitem.Unit;
import com.deft.patterns.abstractfactory.gameitem.impl.DefaultHero;
import com.deft.patterns.abstractfactory.gameitem.impl.base.DefaultChest;
import com.deft.patterns.abstractfactory.gameitem.impl.base.DefaultUnit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 *
 * Default factory
 */
public class DefaultFactory implements EventFactory {

    @Override
    public Chest getChest() {
        return new DefaultChest();
    }

    @Override
    public Unit getUnit() {
        return new DefaultUnit();
    }

    @Override
    public Hero getHero() {
        return new DefaultHero();
    }
}
