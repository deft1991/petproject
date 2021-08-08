package com.deft.patterns.prototype;

import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2021
 */
public class ArcherEnemy extends Enemy{

    public int attackRange;

    public ArcherEnemy() {
    }

    public ArcherEnemy(ArcherEnemy target) {
        super(target);
        if (target != null) {
            this.attackRange = target.attackRange;
        }
    }

    @Override
    public Enemy clone() {
        return new ArcherEnemy(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArcherEnemy that = (ArcherEnemy) o;
        return attackRange == that.attackRange ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackRange);
    }
}
