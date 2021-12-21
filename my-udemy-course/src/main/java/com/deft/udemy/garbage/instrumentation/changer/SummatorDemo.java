package com.deft.udemy.garbage.instrumentation.changer;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2021
 *
 * java -javaagent:summatorDemo.jar -jar summatorDemo.jar
 */
public class SummatorDemo {
    public static void main(String[] args) {
        QAnyClass QAnyClass = new QAnyClass();
        System.out.println(QAnyClass.summator(30, 20));
    }
}
