package com.deft.udemy.instrumentation.proxy;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 *
 * java -javaagent:proxyDemo.jar -jar proxyDemo.jar
 */
public class ProxyDemo {

    public static void main(String[] args) {
        MyClassImpl myClass = new MyClassImpl();
        myClass.secureAccess("Security Param");
    }
}

