package com.deft.udemy.solid.poly;

/**
 * @author Sergey Golitsyn
 * created on 12.10.2021
 */
public class Update implements Operation {

    @Override
    public void action(String data) {
        System.out.println("update, data:" + data);
    }
}

