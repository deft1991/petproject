package com.deft.patterns.flyweight.heavy;

import java.awt.*;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class FrameType {
    private String name;
    private Color color;
    private String otherFrameData;

    public FrameType(String name, Color color, String otherFrameData) {
        this.name = name;
        this.color = color;
        this.otherFrameData = otherFrameData;
    }
}
