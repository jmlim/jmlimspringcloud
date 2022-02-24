package io.jmlim.catalogservice.catalog.service;

import io.jmlim.catalogservice.catalog.entity.Catalog;

public interface CatalogService {
    Iterable<Catalog> getAllCatalogs();
}
