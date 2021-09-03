package com.deft.patterns.flyweight.heavy;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
// heavy object
public class Icon {

    private String type;
    private int height;
    private int length;
    private byte[] data;
    // other fields


    public Icon(String type, int height, int length, byte[] data) {
        this.type = type;
        this.height = height;
        this.length = length;
        this.data = data;
    }
}
