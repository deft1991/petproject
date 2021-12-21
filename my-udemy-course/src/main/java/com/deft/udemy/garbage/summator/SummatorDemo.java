package com.deft.udemy.garbage.summator;

/**
 * @author Sergey Golitsyn
 * created on 05.10.2021
 * java -javaagent:summatorDemo.jar -jar summatorDemo.jar
 */
public class SummatorDemo {
    public static void main(String[] args) {
        AnyClass anyClass = new AnyClass();
        System.out.println(anyClass.summator(30, 20));
    }
}
