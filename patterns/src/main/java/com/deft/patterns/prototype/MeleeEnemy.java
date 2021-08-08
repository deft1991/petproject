package com.deft.patterns.prototype;

import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2021
 */
public class MeleeEnemy extends Enemy {

    public int blockChance;
    public boolean withShield;

    public MeleeEnemy() {
    }

    public MeleeEnemy(MeleeEnemy target) {
        super(target);
        if (target != null) {
            this.blockChance = target.blockChance;
            this.withShield = target.withShield;
        }
    }

    @Override
    public Enemy clone() {
        return new MeleeEnemy(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MeleeEnemy that = (MeleeEnemy) o;
        return blockChance == that.blockChance && withShield == that.withShield;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blockChance, withShield);
    }
}
