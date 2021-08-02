package com.deft.patterns.abstractfactory.gameitem;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public interface Hero {

    /*
     * Get URL where client can download skin, or
     * we can return skin config name.
     * It depends.
     */
    String getSkinURL();

    /*
     * For some events we want to change item names;
     */
    String getName();
}
