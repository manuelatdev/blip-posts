package com.malbaladejo.blip.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Blip {

    private final UUID blipId;
    private final UUID userId;
    private final BlipContent content;
    private final LocalDateTime timestamp;

    public Blip(UUID userId, BlipContent content) {
        this.blipId = UUID.randomUUID();
        this.userId = Objects.requireNonNull(userId, "userId no puede ser null");
        this.content = Objects.requireNonNull(content, "content no puede ser null");
        this.timestamp = LocalDateTime.now();
    }

    public Blip(UUID blipId, UUID userId, BlipContent content, LocalDateTime timestamp) {
        this.blipId = blipId;
        this.userId = Objects.requireNonNull(userId, "userId no puede ser null");
        this.content = Objects.requireNonNull(content, "content no puede ser null");
        this.timestamp = Objects.requireNonNull(timestamp, "timestamp no puede ser null");
    }
}
