package com.deft.udemy.solid.poly;

/**
 * @author Sergey Golitsyn
 * created on 12.10.2021
 */
public class PolyGood {
    public static void main(String[] args) {
        new PolyGood().go("OK1", new Create());
        new PolyGood().go("OK2", new Update());
        // Как добавить select?
    }

    private void go(String data, Operation operation) {
        operation.action(data);
    }
}
