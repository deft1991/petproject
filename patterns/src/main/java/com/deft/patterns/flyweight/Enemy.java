package com.deft.patterns.flyweight;

import com.deft.patterns.flyweight.factory.FrameFactory;
import com.deft.patterns.flyweight.factory.IconFactory;
import com.deft.patterns.flyweight.heavy.Frame;
import com.deft.patterns.flyweight.heavy.FrameType;
import com.deft.patterns.flyweight.heavy.Icon;
import com.deft.patterns.flyweight.heavy.Weapon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class Enemy {
    private Frame frame;
    private Icon icon;
    private Weapon weapon;

    public Enemy(Frame frame, Icon icon, Weapon weapon) {
        this.frame = frame;
        this.icon = icon;
        this.weapon = weapon;
    }
}
