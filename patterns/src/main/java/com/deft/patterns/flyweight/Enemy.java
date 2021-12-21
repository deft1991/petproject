package com.deft.patterns.flyweight;

import com.deft.patterns.flyweight.factory.FrameTypeFactory;
import com.deft.patterns.flyweight.factory.IconFactory;
import com.deft.patterns.flyweight.heavy.FrameType;
import com.deft.patterns.flyweight.heavy.Icon;

import java.awt.*;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class Enemy {
    private FrameType frame;
    private Icon icon;

    // other data

    private String name;
    private int hitPoint;

    public Enemy() {
    }

    public Enemy(FrameType frame, Icon icon) {
        this.frame = frame;
        this.icon = icon;
    }

    public void createEnemy(String enemyName, int hitPoint, String name, Color color, String otherFrameData, String iconType, int height, int length, byte[] data) {
        createEnemyFrame(name, color, otherFrameData);
        createEnemyIcon(iconType, height, length, data);
        this.name = enemyName;
        this.hitPoint = hitPoint;
    }

    private void createEnemyFrame(String name, Color color, String otherFrameData) {
        frame = FrameTypeFactory.getFrameType(name, color, otherFrameData);
    }

    private void createEnemyIcon(String type, int height, int length, byte[] data) {
        icon = IconFactory.getIcon(type, height, length, data);
    }
}
