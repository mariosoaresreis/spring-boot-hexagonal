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

    @GetMapping("/hello")
    public String hello(){
        return "Mario is the smartest guy in the room";
    }

    @PostMapping
    void createProducts(@RequestBody ProductDTO productDTO) {
        productServicePort.createProduct(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        return productServicePort.findProducts();
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws NotFoundException {
        productServicePort.updateStock(sku, stockDTO);
    }
}
