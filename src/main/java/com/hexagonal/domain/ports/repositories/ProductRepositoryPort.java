package com.hexagonal.domain.ports.repositories;

import com.hexagonal.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {
    List<Product> findAll();

    Product findBySKU(String sku);

    void save(Product product);
}
