package com.example.application.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2020
 */

@Getter
@Setter
@Entity
@Table(name = "attack_layer_type")
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public class AttackLayerType extends AbstractEntity {


    @Column(name = "alias", nullable = false, length = 100)
    private String alias;

    public AttackLayerType() {
    }

    public AttackLayerType(Long id, String alias) {
        setId(id);
        this.alias = alias;
    }
}
