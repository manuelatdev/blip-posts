package com.malbaladejo.blip.infrastructure;

import com.malbaladejo.blip.domain.Blip;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlipRepository {
    Blip save(Blip blip);
    Optional<Blip> findById(UUID blipId);
    List<Blip> findLatest(int limit);
}
