package com.example.application.data.service;

import com.example.application.data.model.DisplacementLayerType;
import com.example.application.data.repository.DisplacementLayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2020
 */

@Service
public class DisplacementLayerTypeService extends CrudService<DisplacementLayerType, Long> {

    private final DisplacementLayerRepository repository;

    public DisplacementLayerTypeService(@Autowired DisplacementLayerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected DisplacementLayerRepository getRepository() {
        return repository;
    }
}
