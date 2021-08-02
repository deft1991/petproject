package com.deft.patterns.abstractfactory.gameitem.impl.space;

import com.deft.patterns.abstractfactory.gameitem.Unit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class SpaceUnit implements Unit {

    @Override
    public String getSkinURL() {
        return "Space unit url";
    }

    @Override
    public String getName() {
        return "Space unit";
    }
}
