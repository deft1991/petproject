package com.deft.patterns.abstractfactory.gameitem.impl.pirate;

import com.deft.patterns.abstractfactory.gameitem.Hero;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class PirateHero implements Hero {

    @Override
    public String getSkinURL() {
        return "Pirate hero url";
    }

    @Override
    public String getName() {
        return "Pirate hero";
    }
}
