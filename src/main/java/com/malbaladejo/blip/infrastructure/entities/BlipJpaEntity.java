package com.malbaladejo.blip.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "blips")
@Getter
@NoArgsConstructor
public class BlipJpaEntity {

    @Id
    private UUID blipId;

    private UUID userId;

    @Embedded
    private BlipContentJpa content;

    private LocalDateTime timestamp;

    public BlipJpaEntity(UUID blipId, UUID userId, BlipContentJpa content, LocalDateTime timestamp) {
        this.blipId = blipId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }
}