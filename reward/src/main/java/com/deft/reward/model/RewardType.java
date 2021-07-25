package com.deft.reward.model;

import lombok.Getter;

/**
 * @author Sergey Golitsyn
 * created on 16.04.2021
 */

@Getter
public enum RewardType {
    CARD,
    CHANCE_REWARD,
    CHEST,
    GOLD,
    GEM,
    CLOSE_CARD,
    OPEN_CARD,
    RATING,
    CARD_UPGRADE,
    TOKEN,
    TOKEN_CHEST
}
