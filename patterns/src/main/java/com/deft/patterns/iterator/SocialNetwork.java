package com.deft.patterns.iterator;

/**
 * @author Sergey Golitsyn
 * created on 24.08.2021
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
