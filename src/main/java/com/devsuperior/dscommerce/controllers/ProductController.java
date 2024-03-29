package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.controllers.dto.ProductDTO;
import com.devsuperior.dscommerce.controllers.dto.ProductMinDTO;
import com.devsuperior.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// @RestController garante que será respondido pela web
@RestController
// Rota
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    // @PathVariable está configurando o parâmetro de rota
        public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        /*
            ProductDTO dto = service.findById(id);
            return dto;
        */
        ProductDTO dto =  service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    // Passando Pageable para ser uma busca paginada
    public ResponseEntity<Page<ProductMinDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<ProductMinDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    // @Valid irá validar as notations feitas nos atributos do ProductDTI
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto =  service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    // @Valid é no corpo e não na PathVariable
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        dto =  service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        // resposta que dá certo e não tem corpo (código 204)
        return ResponseEntity.noContent().build();
    }
}
