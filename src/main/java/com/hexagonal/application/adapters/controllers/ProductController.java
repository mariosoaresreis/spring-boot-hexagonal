package com.hexagonal.application.adapters.controllers;

import com.hexagonal.domain.dtos.StockDTO;
import com.hexagonal.domain.dtos.ProductDTO;
import com.hexagonal.domain.ports.interfaces.ProductServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    void criarProdutos(@RequestBody ProductDTO productDTO) {
        productServicePort.createProduct(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProdutos() {
        return productServicePort.searchProducts();
    }

    @PutMapping(value = "/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws NotFoundException {
        productServicePort.updateStock(sku, stockDTO);
    }
}
