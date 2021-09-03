package com.deft.patterns.flyweight.heavy;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class Frame {
    private int x;
    private int y;
    private FrameType type;
    // other fields

    public Frame(int x, int y, FrameType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
