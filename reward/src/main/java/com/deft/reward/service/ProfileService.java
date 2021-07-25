package com.deft.reward.service;


import com.deft.reward.model.Profile;

/**
 * @author Sergey Golitsyn
 * created on 14.10.2020
 */
public interface ProfileService {

    Profile getCurrentProfile();

    Long getCurrentProfileId();

}
