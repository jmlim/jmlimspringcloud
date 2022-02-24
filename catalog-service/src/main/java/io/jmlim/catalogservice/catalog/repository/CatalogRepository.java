package io.jmlim.catalogservice.catalog.repository;

import io.jmlim.catalogservice.catalog.entity.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {

    Catalog findByProductId(String productId);
}
