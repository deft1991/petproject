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
 * created on 03.12.2020
 */

@Getter
@Setter
@Entity
@Table(name = "unit_type")
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public class UnitType extends AbstractEntity {

    @Column(name = "alias", /*nullable = false,*/ length = 100)
    private String alias;

    public UnitType() {
    }

    public UnitType(String alias) {
        this.alias = alias;
    }


    public UnitType(Long id, String alias) {
        this.setId(id);
        this.alias = alias;
    }



}
