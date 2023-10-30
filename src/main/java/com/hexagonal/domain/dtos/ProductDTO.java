package com.hexagonal.domain.dtos;

public class ProductDTO {
    private String sku;
    private String name;
    private Double price;
    private Double quantity;

    public ProductDTO(String sku, String name, Double price, Double quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
}
