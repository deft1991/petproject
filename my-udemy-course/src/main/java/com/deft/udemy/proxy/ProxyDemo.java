package com.deft.udemy.proxy;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 */
public class ProxyDemo {
    public static void main(String[] args) {
        MyClassInterface myClass = Ioc.createMyClass();
        myClass.secureAccess("Security Param");
    }
}
