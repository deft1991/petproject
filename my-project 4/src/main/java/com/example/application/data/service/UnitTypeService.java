package com.example.application.data.service;

import com.example.application.data.model.UnitType;
import com.example.application.data.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */

@Service
public class UnitTypeService extends CrudService<UnitType, Long> {

    private final UnitTypeRepository repository;

    public UnitTypeService(@Autowired UnitTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected UnitTypeRepository getRepository() {
        return repository;
    }
}
