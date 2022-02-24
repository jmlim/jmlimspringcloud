package io.jmlim.catalogservice.catalog.controller;

import io.jmlim.catalogservice.catalog.entity.Catalog;
import io.jmlim.catalogservice.catalog.service.CatalogService;
import io.jmlim.catalogservice.catalog.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;


    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {
        return String.format("It's Working in Catalog Service on Port %s", request.getServerPort());
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        Iterable<Catalog> orders = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        orders.forEach(v -> result.add(new ModelMapper().map(v, ResponseCatalog.class)));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
