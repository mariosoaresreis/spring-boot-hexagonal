package com.hexagonal.domain.ports.interfaces;

import com.hexagonal.domain.dtos.StockDTO;
import com.hexagonal.domain.dtos.ProductDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProductServicePort {

    List<ProductDTO> findProducts();

    void createProduct(ProductDTO productDTO);

    void updateStock(String sku, StockDTO stockDTO) throws NotFoundException;
}
