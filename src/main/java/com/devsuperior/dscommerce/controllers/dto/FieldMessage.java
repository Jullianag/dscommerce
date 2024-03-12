package com.devsuperior.dscommerce.controllers.dto;

public class FieldMessage {

    // Nome do campo e mensagem
    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
