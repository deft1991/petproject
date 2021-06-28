package com.example.application.data.service;

import com.example.application.data.model.AttackType;
import com.example.application.data.model.UnitType;
import com.example.application.data.repository.AttackTypeRepository;
import com.example.application.data.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */

@Service
public class AttackTypeService extends CrudService<AttackType, Long> {

    private final AttackTypeRepository repository;

    public AttackTypeService(@Autowired AttackTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected AttackTypeRepository getRepository() {
        return repository;
    }
}
