package com.deft.patterns.abstractfactory.gameitem.impl.space;

import com.deft.patterns.abstractfactory.gameitem.Hero;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class SpaceHero implements Hero {

    @Override
    public String getSkinURL() {
        return "Space hero url";
    }

    @Override
    public String getName() {
        return "Space hero";
    }
}
