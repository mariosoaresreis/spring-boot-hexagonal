package com.hexagonal.domain;

import com.hexagonal.domain.dtos.ProductDTO;

import java.util.UUID;

public class Product {

    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double quantity;

    public Product() {
    }

    public Product(UUID code, String sku, String name, Double quantity, Double price) {
        this.code = code;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getCode() {
        return code;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Product(ProductDTO productDTO) {
        this.sku = productDTO.getSku();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.quantity = productDTO.getQuantity();
    }

    public void updateStock(double quantidade) {
        this.quantity = quantidade;
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(this.sku, this.name, this.price, this.quantity);
    }
}
