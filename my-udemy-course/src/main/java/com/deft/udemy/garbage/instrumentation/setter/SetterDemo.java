package com.deft.udemy.garbage.instrumentation.setter;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 *
 * java -javaagent:setterDemo.jar -jar setterDemo.jar
 */
public class SetterDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("main");
        MyClass demo = new MyClass();
        System.out.println(demo.getValue());
//        modifyPrivateValue(demo);
        System.out.println(-4);
    }

    private static void modifyPrivateValue(MyClass demo) throws Exception {
        demo.getClass().getMethod("setValue", int.class).invoke(demo, -4);
    }
}
