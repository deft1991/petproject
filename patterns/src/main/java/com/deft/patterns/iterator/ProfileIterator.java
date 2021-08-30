package com.deft.patterns.iterator;

/**
 * @author Sergey Golitsyn
 * created on 24.08.2021
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
