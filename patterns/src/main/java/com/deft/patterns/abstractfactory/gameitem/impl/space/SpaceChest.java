package com.deft.patterns.abstractfactory.gameitem.impl.space;

import com.deft.patterns.abstractfactory.gameitem.Chest;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class SpaceChest implements Chest {

    @Override
    public String getSkinURL() {
        return "Space url";
    }

    @Override
    public String getName() {
        return "Space chest";
    }
}
