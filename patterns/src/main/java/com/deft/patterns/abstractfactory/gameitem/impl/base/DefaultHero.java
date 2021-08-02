package com.deft.patterns.abstractfactory.gameitem.impl;

import com.deft.patterns.abstractfactory.gameitem.Hero;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class DefaultHero implements Hero {

    @Override
    public String getSkinURL() {
        return "default hero url";
    }

    @Override
    public String getName() {
        return "default hero";
    }
}
