package com.deft.udemy.instrumentation.proxy;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 */
public class MyClassImpl {

    public void secureAccess(String param) {
        System.out.println("secureAccess, param:" + param);
    }

    @Override
    public String toString() {
        return "MyClassImpl{}";
    }
}

