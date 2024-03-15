package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.controllers.dto.OrderDTO;
import com.devsuperior.dscommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController garante que será respondido pela web
@RestController
// Rota
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    // @PathVariable está configurando o parâmetro de rota
        public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO dto =  service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
