package com.deft.reward.service.impl;

import com.deft.reward.model.Profile;
import com.deft.reward.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Sergey Golitsyn
 * created on 19.10.2020
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProfileServiceImpl implements ProfileService {

    /**
     * Return current user from token
     *
     * @return current currentProfile
     * <p>
     * //todo add additional info if needed
     */
    @Override
    @Transactional(readOnly = true)
    public Profile getCurrentProfile() {
        Profile profile = new Profile();
        profile.setNickName("test");
        profile.setId(1L);
        return profile;
    }

    @Override
    public Long getCurrentProfileId() {
        return -1L;
    }
}
