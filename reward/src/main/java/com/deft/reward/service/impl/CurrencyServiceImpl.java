package com.deft.reward.service.impl;

import com.deft.reward.model.Currency;
import com.deft.reward.repository.CurrencyRepository;
import com.deft.reward.service.GameContentService;
import com.deft.reward.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sergey Golitsyn
 * created on 25.02.2021
 */

@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyServiceImpl implements GameContentService<Currency> {

    private final CurrencyRepository<Currency> currencyRepository;

    private final ProfileService profileService;

    @Override
    public Currency saveOrUpdate(Currency content) {
        Currency currency = currencyRepository.findByProfileIdAndType(content.getProfile().getId(), content.getType());

        if (currency == null) {
            return currencyRepository.save(content);
        } else {
            currency.setCount(currency.getCount() + content.getCount());
            return currencyRepository.save(currency);
        }

    }

    @Override
    public Class<Currency> getSupportedType() {
        return Currency.class;
    }

}
