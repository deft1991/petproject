package com.example.application.data.repository;

import com.example.application.data.model.AttackLayerType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */
public interface AttackLayerTypeRepository extends JpaRepository<AttackLayerType, Long> {
}
