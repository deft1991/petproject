package com.deft.cource.first;

/**
 * @author Sergey Golitsyn
 * created on 31.08.2021
 */
public class GenericsMethod {

    private <K, V> void print(K key, V val) {
        System.out.println("key:" + key + ", val:" + val);
    }
}
