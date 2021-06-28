package com.example.application.data.repository;

import com.example.application.data.model.DisplacementLayerType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2020
 */
public interface DisplacementLayerRepository extends JpaRepository<DisplacementLayerType, Long> {
}
