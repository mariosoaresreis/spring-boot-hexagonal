package com.hexagonal.infrastructure.adapters.entities;

import com.hexagonal.domain.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double quantity;

    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.sku = product.getSku();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public void update(Product product) {
        this.sku = product.getSku();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public Product toProduct() {
        return new Product(this.code, this.sku, this.name, this.quantity, this.price);
    }
}
