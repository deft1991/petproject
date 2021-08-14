package com.deft.patterns.composite;

import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2021
 */
public class GoldReward extends BaseReward {

    GoldReward(){
        super("GOLD");
    }

    @Override
    public List<?> rewardFor() {
        /*
         * We can return list of needed DTO objects
         * Now we only print it
         */
        System.out.println("rewardFor: " + this.getType());
       return Collections.emptyList();
    }

}
