package com.deft.reward.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

/**
 * @author Sergey Golitsyn
 * created on 06.04.2021
 */

@Getter
@Setter
@Entity(name = "reward")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING)
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public abstract class Reward implements GameItem {

    /**
     * Идентификатор сущности
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_reward"
    )
    @SequenceGenerator(
            name = "seq_reward",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false, length = 36, unique = true)
    private Long id;

    @Column(name = "alias", length = 255)
    private String alias; // short description

    @Column(name = "min_count")
    private Integer minCount = 0; // it is diff card count for card reward, can be null for some rewards

    @Column(name = "max_count")
    private Integer maxCount = 0; // it is diff card count for card reward, can be null for some rewards

    /**
     * if this field filled it is mean we want this reward count.
     */
    @Column(name = "count")
    private Integer count = 0; // it is diff card count for card reward, can be null for some rewards

    /**
     * Тип валюты за который можно купить сундук
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    /**
     * Количество валюты за которое можно купить сундук
     */
    @Column(name = "currency_count")
    private Integer currencyCount;

    @UpdateTimestamp
    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;


    public abstract RewardType getType();

}
