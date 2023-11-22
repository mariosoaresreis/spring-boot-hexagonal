package com.hexagonal.domain.adapters.services;

import com.hexagonal.domain.Product;
import com.hexagonal.domain.dtos.StockDTO;
import com.hexagonal.domain.dtos.ProductDTO;
import com.hexagonal.domain.ports.interfaces.ProductServicePort;
import com.hexagonal.domain.ports.repositories.ProductRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductServiceImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        this.productRepository.save(product);
    }

    @Override
    public List<ProductDTO> findProducts() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(Product::toProductDTO).collect(Collectors.toList());
    }

    @Override
    public void updateStock(String sku, StockDTO stockDTO) throws NotFoundException {
        Product product = this.productRepository.findBySKU(sku);

        if (Objects.isNull(product))
            throw new NotFoundException("Product not found!");

        product.updateStock(stockDTO.getQuantity());

        this.productRepository.save(product);
    }
}
