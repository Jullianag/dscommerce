package com.devsuperior.dscommerce.controllers.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer staus;
    private String error;
    private String path;

    public CustomError(Instant timestamp, Integer staus, String error, String path) {
        this.timestamp = timestamp;
        this.staus = staus;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStaus() {
        return staus;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
