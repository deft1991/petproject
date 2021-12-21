package com.deft.udemy.solid.poly;

/**
 * @author Sergey Golitsyn
 * created on 12.10.2021
 */
public class Create implements Operation {

    @Override
    public void action(String data) {
        System.out.println("create, data:" + data);
    }
}
