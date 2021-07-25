package com.deft.reward.repository;

import com.deft.reward.model.Currency;
import com.deft.reward.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 25.02.2021
 */
public interface CurrencyRepository<T extends Currency> extends JpaRepository<T, Long> {

    List<T> findAllByProfileId(long profileId);

    List<T> findAllByProfile(Profile profile);

    T findByProfileId(long profileId);

    Currency findByProfileIdAndType(long profileId, String type);
}
