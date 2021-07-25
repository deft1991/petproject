package com.deft.reward.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * @author Sergey Golitsyn
 * created on 13.10.2020
 */
@Getter
@Setter
@Entity
@Table(name = "profile")
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public class Profile {

    /**
     * Идентификатор сущности
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_profile"
    )
    @SequenceGenerator(
            name = "seq_profile",
            allocationSize = 100
    )
    @Column(name = "id", nullable = false, length = 36, unique = true)
    private Long id;

    @Column(name = "nick_name", nullable = false, length = 100)
    private String nickName;

    @Version
    @Column(name = "version", columnDefinition = "int4 DEFAULT 0", nullable = false)
    private Long version = 0L;

    @Column(name = "rating", nullable = false)
    private int rating = 0;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "is_tutor_completed", nullable = false)
    private boolean tutorialCompleted = false;

}
