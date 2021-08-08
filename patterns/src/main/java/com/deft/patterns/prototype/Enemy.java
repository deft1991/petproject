package com.deft.patterns.prototype;

import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2021
 */
public abstract class Enemy {

    public int health;
    public int speed;
    public String name;

    public Enemy() {
    }

    public Enemy(Enemy target) {
        if (target != null) {
            this.health = target.health;
            this.speed = target.speed;
            this.name = target.name;
        }
    }

    public abstract Enemy clone();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemy)) return false;
        Enemy enemy = (Enemy) o;
        return enemy.health == health && enemy.speed == speed && Objects.equals(enemy.name, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, speed, name);
    }
}
