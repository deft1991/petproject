package com.deft.patterns.abstractfactory.gameitem.impl.pirate;

import com.deft.patterns.abstractfactory.gameitem.Chest;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class PirateChest implements Chest {

    @Override
    public String getSkinURL() {
        return "Pirate url";
    }

    @Override
    public String getName() {
        return "Pirate chest";
    }
}
