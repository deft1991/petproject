package com.deft.reward.repository;

import com.deft.reward.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2021
 */
public interface RewardRepository<T extends Reward> extends JpaRepository<T, Long> {
}
