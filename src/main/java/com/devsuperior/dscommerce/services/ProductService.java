package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.controllers.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // O service retorna DTO na arquitetura
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        /*
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
         */

        Product product = repository.findById(id).get();
        // converter para DTO
        return new ProductDTO(product);
    }
}
