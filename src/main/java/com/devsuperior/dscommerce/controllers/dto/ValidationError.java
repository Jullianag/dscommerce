package com.devsuperior.dscommerce.controllers.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer staus, String error, String path) {
        super(timestamp, staus, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    // método para adicionar mensagens a Lista
    public void addError(String fieldName, String message) {
        errors.removeIf(x -> x.getFieldName().equals(message));
        errors.add(new FieldMessage(fieldName, message));
    }
}
