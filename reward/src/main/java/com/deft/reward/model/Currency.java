package com.deft.reward.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.time.ZonedDateTime;

/**
 * @author Sergey Golitsyn
 * created on 25.02.2021
 */

@Getter
@Setter
@Entity(name = "currency")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
        discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public abstract class Currency {

    /**
     * Идентификатор сущности
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_commodity"
    )
    @SequenceGenerator(
            name = "seq_commodity",
            allocationSize = 10
    )
    @Column(name = "id", nullable = false, length = 36, unique = true)
    private Long id;

    /**
     * Профиль пользователя
     */
    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    @Column(name = "count")
    private Integer count = 0;

    /**
     * This column uses as @DiscriminatorColumn, that is why insertable and updatable set as false
     */
    @Column(name = "type", insertable = false, updatable = false)
    @Deprecated
    private String type;

    @UpdateTimestamp
    @Column(name = "last_modified_date", nullable = false)
    private ZonedDateTime lastModifiedDate;


    public Currency(Profile profile, Integer count) {
        this.profile = profile;
        this.count = count;
    }

    public String getType() {
        return type;
    }
}
