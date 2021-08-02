package com.deft.patterns.abstractfactory.gameitem.impl.pirate;

import com.deft.patterns.abstractfactory.gameitem.Unit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class PirateUnit implements Unit {

    @Override
    public String getSkinURL() {
        return "Pirate unit url";
    }

    @Override
    public String getName() {
        return "Pirate unit";
    }
}
