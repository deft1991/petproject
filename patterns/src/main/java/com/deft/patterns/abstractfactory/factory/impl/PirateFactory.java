package com.deft.patterns.abstractfactory.factory.impl;

import com.deft.patterns.abstractfactory.factory.EventFactory;
import com.deft.patterns.abstractfactory.gameitem.Chest;
import com.deft.patterns.abstractfactory.gameitem.Hero;
import com.deft.patterns.abstractfactory.gameitem.Unit;
import com.deft.patterns.abstractfactory.gameitem.impl.pirate.PirateChest;
import com.deft.patterns.abstractfactory.gameitem.impl.pirate.PirateHero;
import com.deft.patterns.abstractfactory.gameitem.impl.pirate.PirateUnit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 *
 * Pirate event factory
 */
public class PirateFactory implements EventFactory {

    @Override
    public Chest getChest() {
        return new PirateChest();
    }

    @Override
    public Unit getUnit() {
        return new PirateUnit();
    }

    @Override
    public Hero getHero() {
        return new PirateHero();
    }
}
