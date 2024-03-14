package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.controllers.dto.ProductDTO;
import com.devsuperior.dscommerce.controllers.dto.UserDTO;
import com.devsuperior.dscommerce.services.ProductService;
import com.devsuperior.dscommerce.services.UserService;
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
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/me")
    // @PathVariable está configurando o parâmetro de rota
        public ResponseEntity<UserDTO> getMe() {
        /*
            ProductDTO dto = service.findById(id);
            return dto;
        */
        UserDTO dto =  service.getMe();
        return ResponseEntity.ok(dto);
    }

}
