package com.example.application.data.service;

import com.example.application.data.model.AttackLayerType;
import com.example.application.data.repository.AttackLayerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2020
 */

@Service
public class AttackLayerTypeService extends CrudService<AttackLayerType, Long> {

    private final AttackLayerTypeRepository repository;

    public AttackLayerTypeService(@Autowired AttackLayerTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected AttackLayerTypeRepository getRepository() {
        return repository;
    }
}
