package com.deft.patterns.abstractfactory.gameitem.impl.base;

import com.deft.patterns.abstractfactory.gameitem.Unit;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class DefaultUnit implements Unit {

    @Override
    public String getSkinURL() {
        return "default unit url";
    }

    @Override
    public String getName() {
        return "default unit";
    }
}
