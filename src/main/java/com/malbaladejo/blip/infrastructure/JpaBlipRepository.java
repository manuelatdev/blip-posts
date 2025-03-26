package com.malbaladejo.blip.infrastructure;

import com.malbaladejo.blip.infrastructure.entities.BlipJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBlipRepository extends JpaRepository<BlipJpaEntity, UUID> {
}
