package io.jmlim.catalogservice.catalog.service.impl;

import io.jmlim.catalogservice.catalog.entity.Catalog;
import io.jmlim.catalogservice.catalog.repository.CatalogRepository;
import io.jmlim.catalogservice.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository repository;
    private final Environment env;

    @Override
    public Iterable<Catalog> getAllCatalogs() {
        return repository.findAll();
    }
}
