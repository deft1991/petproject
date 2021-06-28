package com.example.application.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */

@Getter
@Setter
@Entity
@Table(name = "unit")
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include = "non-lazy")
public class Unit extends AbstractEntity {

    private String name;
    private String description;
    private int cost;
    private int count;

    //    Main
    private int addCapacity;
    private int unitHealth;
    private int unitsInGroup;
    private int speed;
    private int minRange;
    private int range;
    private int damage;
    private int dps;
    private int fogOfWarRange;
    private boolean canAttackOnMove;
    private int unitFirstFireCooldown;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_type_id", referencedColumnName = "id"/*, nullable = false*/)
    private UnitType unitType;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "unit_to_displacement_layer_type",
            joinColumns = @JoinColumn(name = "unit_id"),
            inverseJoinColumns = @JoinColumn(name = "displacement_layer_type_id")
    )
    private Set<DisplacementLayerType> displacementLayerTypes;


    public Unit() {
    }

    public Unit(String name
            , String description
            , int cost
            , int count
            , int addCapacity
            , int unitHealth
            , int unitsInGroup
            , UnitType unitType
    ) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.count = count;
        this.addCapacity = addCapacity;
        this.unitHealth = unitHealth;
        this.unitsInGroup = unitsInGroup;

        this.unitType = unitType;
//        this.speed = speed;
//        this.minRange = minRange;
//        this.range = range;
//        this.damage = damage;
//        this.dps = dps;
//        this.fogOfWarRange = fogOfWarRange;
//        this.canAttackOnMove = canAttackOnMove;
//        this.unitFirstFireCooldown = unitFirstFireCooldown;
    }
}
