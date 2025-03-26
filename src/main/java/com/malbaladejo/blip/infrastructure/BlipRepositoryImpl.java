package com.malbaladejo.blip.infrastructure;

import com.malbaladejo.blip.domain.Blip;
import com.malbaladejo.blip.domain.BlipContent;
import com.malbaladejo.blip.infrastructure.entities.BlipContentJpa;
import com.malbaladejo.blip.infrastructure.entities.BlipJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BlipRepositoryImpl implements BlipRepository {
    private final JpaBlipRepository jpaBlipRepository;

    @Override
    public Blip save(Blip blip) {
        BlipContentJpa contentJpa = new BlipContentJpa(blip.getContent().getValue());
        BlipJpaEntity jpaEntity = new BlipJpaEntity(blip.getBlipId(), blip.getUserId(), contentJpa, blip.getTimestamp());
        BlipJpaEntity savedEntity = jpaBlipRepository.save(jpaEntity);
        return new Blip(
                savedEntity.getBlipId(),
                savedEntity.getUserId(),
                new BlipContent(savedEntity.getContent().getValue()),
                savedEntity.getTimestamp()
        );
    }

    @Override
    public Optional<Blip> findById(UUID blipId) {
        return jpaBlipRepository.findById(blipId).map(
                entity -> new Blip(
                        entity.getBlipId(),
                        entity.getUserId(),
                        new BlipContent(entity.getContent().getValue()),
                        entity.getTimestamp()
                )
        );
    }

    @Override
    public List<Blip> findLatest(int limit) {
        // Paginación simple, devuelve los últimos "limit" blips, actualmente 10
        // TODO: Ver si es compatible con el tipo de carga que hace Twitter
        PageRequest pageRequest = PageRequest.of(0, limit, Sort.by("timestamp").descending());
        return jpaBlipRepository.findAll(pageRequest)
                .stream()
                .map(
                        entity -> new Blip(
                                entity.getBlipId(),
                                entity.getUserId(),
                                new BlipContent(entity.getContent().getValue()),
                                entity.getTimestamp()
                        )
                )
                .toList();
    }
}
