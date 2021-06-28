package com.example.application.data.service;

import com.example.application.data.model.Unit;
import com.example.application.data.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class UnitService extends CrudService<Unit, Long> {

    private final UnitRepository repository;

    public UnitService(@Autowired UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    protected UnitRepository getRepository() {
        return repository;
    }

}
