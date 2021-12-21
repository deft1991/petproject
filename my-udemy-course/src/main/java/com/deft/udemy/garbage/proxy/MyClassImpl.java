package com.deft.udemy.garbage.proxy;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 */
public class MyClassImpl implements MyClassInterface {

    @Override
    public void secureAccess(String param) {
        System.out.println("secureAccess, param:" + param);
    }

    @Override
    public String toString() {
        return "MyClassImpl{}";
    }
}
