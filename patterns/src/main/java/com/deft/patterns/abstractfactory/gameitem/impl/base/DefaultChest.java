package com.deft.patterns.abstractfactory.gameitem.impl.base;

import com.deft.patterns.abstractfactory.gameitem.Chest;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class DefaultChest implements Chest {

    @Override
    public String getSkinURL() {
        return "default url";
    }

    @Override
    public String getName() {
        return "Default chest";
    }
}
