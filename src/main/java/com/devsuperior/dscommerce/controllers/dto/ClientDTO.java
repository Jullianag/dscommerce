package com.devsuperior.dscommerce.controllers.dto;

import com.devsuperior.dscommerce.entities.User;

import java.time.Instant;

public class ClientDTO {

    private Long id;
    private String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
