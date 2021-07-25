package com.deft.reward.service.impl;

import com.deft.reward.model.Profile;
import com.deft.reward.model.Reward;
import com.deft.reward.repository.RewardRepository;
import com.deft.reward.service.ContentGenerator;
import com.deft.reward.service.GameContentService;
import com.deft.reward.service.ProfileService;
import com.deft.reward.service.RewardService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 12.04.2021
 */

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings({"rawtypes", "unchecked"})
public class RewardServiceImpl implements RewardService {

    private final RewardRepository rewardRepository;

    private final ProfileService profileService;

    private final List<GameContentService> gameContentServices;
    private final ContentGenerator contentGenerator;

    @Override
    @SneakyThrows
    public List<Object> claimReward(long rewardId) {

        Profile currentProfile = profileService.getCurrentProfile();
        Reward reward = (Reward) rewardRepository.findById(rewardId).orElseThrow(() -> new RuntimeException("Reward not found"));

        return claimReward(currentProfile, reward);
    }

    @Override
    @SneakyThrows
    public List<Object> claimReward(Profile profile, Reward reward) {

        /*
         * Pre process reward
         */
        preProcessReward(profile, reward);
        /*
         * Withdraw price if needed
         */
        withdrawRewardPrice(profile, reward);

        // todo group by type and process groups
        List<?> rewards = reward.rewardFor(profile, contentGenerator);

        Map<Class, GameContentService> mapContentServices = gameContentServices
                .stream()
                .collect(Collectors.toMap(GameContentService::getSupportedType, gameContentService -> gameContentService));

        List<Object> resultList = new ArrayList<>();

        /*
         * Save and apply reward for profile
         */
        processReward(rewards, mapContentServices, resultList);

        /*
         * Post process reward
         */
        postProcessReward(profile, reward);

        return resultList;
    }

    /**
     * Pre process reward
     * Make additional calculations for reward
     */
    private void preProcessReward(Profile profile, Reward reward) {
        preProcessors.stream()
                .filter(preProcessor -> preProcessor.getSupportedRewardType() == reward.getType())
                .forEach(preProcessor -> preProcessor.preProcessReward(profile, reward));
    }

    /**
     * Post process reward
     * Make additional calculations for reward
     */
    private void postProcessReward(Profile profile, Reward reward) {
        postProcessors.stream()
                .filter(postProcessor -> postProcessor.getSupportedRewardType() == reward.getType())
                .forEach(postProcessor -> postProcessor.postProcessReward(profile, reward));
    }

    /**
     * Save reward content and apply it for profile
     */
    private void processReward(List<?> rewards, Map<Class, GameContentService> mapContentServices, List<Object> resultList) {
        rewards.forEach(rewardObj -> {
            Class<?> superclass = rewardObj.getClass().getSuperclass();
            if (mapContentServices.containsKey(rewardObj.getClass())) {
                Object saveOrUpdate = mapContentServices.get(rewardObj.getClass()).saveOrUpdate(rewardObj);
                resultList.add(saveOrUpdate);
            } else if (mapContentServices.containsKey(superclass)) {
                Object saveOrUpdate = mapContentServices.get(superclass).saveOrUpdate(rewardObj);
                resultList.add(saveOrUpdate);
            }
        });
    }

    @Override
    public List<Object> claimReward(Profile profile, List<Reward> rewards) {
        return rewards.stream()
                .flatMap(reward -> claimReward(profile, reward).stream())
                .collect(Collectors.toList());
    }

    /**
     * Withdraw currency for reward with price.
     * 1) Check that reward have price.
     * 2) Withdraw currency.
     * 3) Otherwise throw Not enough founds.
     */
    private void withdrawRewardPrice(Profile currentProfile, Reward reward) {
        if (reward.getCurrencyCount() != null && reward.getCurrencyType() != null) {
            boolean isEnoughCurrency = currencyService
                    .validateEnoughCurrency(currentProfile.getId(), reward.getCurrencyCount(), reward.getCurrencyType());
            if (isEnoughCurrency) {
                currencyService.withdrawCurrency(currentProfile.getId(), reward.getCurrencyCount(), reward.getCurrencyType());
            } else {
                throw new RuntimeException("Not enough founds!");
            }
        }
    }
}
