package com.deft.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2021
 */
public class Demo {

    public static void main(String[] args) {
        List<Enemy> enemyList = new ArrayList<>();
        List<Enemy> enemyListCopy = new ArrayList<>();

        ArcherEnemy baseArcher = new ArcherEnemy();
        baseArcher.health = 150;
        baseArcher.speed = 35;
        baseArcher.name = "Base Archer";
        baseArcher.attackRange = 100;
        enemyList.add(baseArcher);

        ArcherEnemy baseArcherClone = (ArcherEnemy) baseArcher.clone();
        enemyList.add(baseArcherClone);

        MeleeEnemy baseMeleeEnemy = new MeleeEnemy();
        baseMeleeEnemy.health = 10;
        baseMeleeEnemy.speed = 20;
        baseMeleeEnemy.name = "blue";
        baseMeleeEnemy.blockChance = 7;
        baseMeleeEnemy.withShield = true;
        enemyList.add(baseMeleeEnemy);

        cloneAndCompare(enemyList, enemyListCopy);
    }

    private static void cloneAndCompare(List<Enemy> enemyList, List<Enemy> enemyListCopy) {
        for (Enemy enemy : enemyList) {
            enemyListCopy.add(enemy.clone());
        }

        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i) != enemyListCopy.get(i)) {
                System.out.println(i + ": Enemy are different objects (yay!)");
                if (enemyList.get(i).equals(enemyListCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
