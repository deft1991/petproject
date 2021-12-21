package com.deft.patterns.flyweight;

import java.awt.*;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class Application {

    static int SQUAD_SIZE = 500;
    static int ENEMY_TO_DRAW = 1000000;
    static int ENEMY_TYPES = 2;
    static int ICON_TYPES = 2;

    public static void main(String[] args) {

        Enemy enemy = new Enemy();
        for (int i = 0; i < Math.floor(ENEMY_TO_DRAW / ENEMY_TYPES); i++) {
            // todo think how to create frame, icon, weapon
            // maybe create in cycle all of them and then reuse
            // like create weapons
            // create icons
            // create frames

            enemy.createEnemy(
                    "Enemy Name " + i,
                    i,
                    "Gold Frame",
                    Color.GREEN,
                    "Gold texture stub",
                    "Rarity Icon",
                    random(0, SQUAD_SIZE),
                    random(0, SQUAD_SIZE), new byte[]{1});
            enemy.createEnemy(
                    "Enemy Name 2 " + i,
                    i * i,
                    "Silver Frame",
                    Color.GREEN,
                    "Silver texture stub",
                    "Common Icon",
                    random(0, SQUAD_SIZE),
                    random(0, SQUAD_SIZE),
                    new byte[]{2});
        }

        System.out.println(ENEMY_TO_DRAW + " enemies drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Enemy size (8 bytes) * " + ENEMY_TO_DRAW);
        System.out.println("+ FrameTypes size (~30 bytes) * " + ENEMY_TYPES + "");
        System.out.println("+ Icon size (~50 bytes) * " + ICON_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((ENEMY_TO_DRAW * 8 + ENEMY_TYPES * 30 + ICON_TYPES * 50) / 1024 / 1024) +
                "MB (instead of " + ((ENEMY_TO_DRAW * 88) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
