package com.deft.reward.model;


import com.deft.reward.service.ContentGenerator;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 06.04.2021
 */

// todo think in which module should place it
public interface GameItem {

    List<?> rewardFor(Profile profile, ContentGenerator contentGenerator);
}
