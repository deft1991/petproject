package com.deft.patterns.factorymethod.generator;

import com.deft.patterns.factorymethod.model.GameItem;

/**
 * @author Sergey Golitsyn
 * created on 31.07.2021
 * Base factory class. Note that "factory" is merely a role for the class. It
 * should have some core business logic which needs different products to be
 * created.
 */
public abstract class ItemGenerator {

    public void openReward() {
        // ... other code ...

        GameItem gameItem = createItem();
        gameItem.open();
    }

    /**
     * Subclasses will override this method in order to create specific reward
     * objects.
     */
    public abstract GameItem createItem();
}
