package com.malbaladejo.blip.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor // Constructor vacío requerido por JPA
public class BlipContentJpa {

    @Column(name = "content_value")
    private String value;

    // Constructor para mapear desde BlipContent del dominio
    public BlipContentJpa(String value) {
        this.value = value;
    }
}