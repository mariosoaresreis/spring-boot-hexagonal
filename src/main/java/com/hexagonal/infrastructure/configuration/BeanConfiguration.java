package com.hexagonal.infrastructure.configuration;

import com.hexagonal.domain.adapters.services.ProductServiceImpl;
import com.hexagonal.domain.ports.interfaces.ProductServicePort;
import com.hexagonal.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductServiceImpl(productRepositoryPort);
    }
}
