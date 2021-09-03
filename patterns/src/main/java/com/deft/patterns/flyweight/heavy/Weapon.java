package com.deft.patterns.flyweight.heavy;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
// heavy object
public class Weapon {
    private String type;
    private int power;
    private int attackRate;
    private int attackSpeed;
    // other fields

    public Weapon(String type, int power, int attackRate, int attackSpeed) {
        this.type = type;
        this.power = power;
        this.attackRate = attackRate;
        this.attackSpeed = attackSpeed;
    }
}
