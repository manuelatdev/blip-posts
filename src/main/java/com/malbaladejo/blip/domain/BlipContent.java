package com.malbaladejo.blip.domain;

import lombok.Value;

import java.util.Objects;

//
@Value
public class BlipContent {
    String value;

    public BlipContent(String value) {
        Objects.requireNonNull(value, "El texto no puede ser nulo");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede ser vacío.");
        }
        if (value.length() > 280) {
            throw new IllegalArgumentException("El texto no puede exceder los 280 caracteres.");
        }
        this.value = value;
    }
}