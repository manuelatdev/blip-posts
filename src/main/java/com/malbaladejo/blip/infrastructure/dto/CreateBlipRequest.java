package com.malbaladejo.blip.infrastructure.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

// Aunque admitimos blips anónimos en este momento, seguramente más adelante no sea así
// Voy estableciendolo para que el user deba ser establecido, uso un userID específico para los anónimos

public record CreateBlipRequest(
        @NotNull(message = "El userId no puede ser nulo") UUID userId,
        @NotNull(message = "El contenido no puede ser nulo") String content) {
}