package com.deft.reward.service;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2021
 */
public interface GameContentService<T> {

    /**
     * Save or update content to profile
     */
    T saveOrUpdate(T content);

    /**
     * Get supported type of Service, for add reward to profile
     */
    Class<T> getSupportedType();
}
