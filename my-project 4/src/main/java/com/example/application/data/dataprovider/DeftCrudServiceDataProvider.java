package com.example.application.data.dataprovider;

import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.helpers.CrudService;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2020
 */
public class DeftCrudServiceDataProvider<T, F> extends FilterablePageableDataProvider<T, F> {

    private final CrudService<T, Long> service;

    private List<QuerySortOrder> defaultSortOrders;

    public DeftCrudServiceDataProvider(CrudService<T, Long> service, QuerySortOrder... defaultSortOrders) {
        this.service = service;
        this.defaultSortOrders = Arrays.asList(defaultSortOrders);
    }

    @Override
    protected Page<T> fetchFromBackEnd(Query<T, F> query, Pageable pageable) {
        return service.list(pageable);
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        return defaultSortOrders;
    }

    @Override
    protected int sizeInBackEnd(Query<T, F> query) {
        return service.count();
    }
}
