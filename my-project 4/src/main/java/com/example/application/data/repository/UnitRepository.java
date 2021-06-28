package com.example.application.data.repository;

import com.example.application.data.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
