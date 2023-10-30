package com.hexagonal;

import com.hexagonal.infrastructure.adapters.repositories.SpringProdutoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SpringProdutoRepository.class)
public class HexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalApplication.class, args);
    }

}
