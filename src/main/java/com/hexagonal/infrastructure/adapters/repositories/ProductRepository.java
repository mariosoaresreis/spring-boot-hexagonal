package com.hexagonal.infrastructure.adapters.repositories;

import com.hexagonal.domain.Product;
import com.hexagonal.domain.ports.repositories.ProductRepositoryPort;
import com.hexagonal.infrastructure.adapters.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProductRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> produtoEntities = this.springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product findBySKU(String sku) {
        Optional<ProductEntity> produtoEntity = this.springProdutoRepository.findBySku(sku);

        if (produtoEntity.isPresent())
            return produtoEntity.get().toProduct();

        throw new RuntimeException("Product not found");
    }

    @Override
    public void save(Product product) {
        ProductEntity productEntity;
        if (Objects.isNull(product.getCode()))
            productEntity = new ProductEntity(product);
        else {
            productEntity = this.springProdutoRepository.findById(product.getCode()).get();
            productEntity.update(product);
        }

        this.springProdutoRepository.save(productEntity);
    }
}
