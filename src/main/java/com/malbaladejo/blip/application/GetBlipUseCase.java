package com.malbaladejo.blip.application;

import com.malbaladejo.blip.domain.Blip;
import com.malbaladejo.blip.infrastructure.BlipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetBlipUseCase {
        private final BlipRepository blipRepository;

        public Blip execute(UUID blipID){
            return blipRepository.findById(blipID).orElseThrow(
                    () -> new IllegalArgumentException("Blip no encontrado con ID: " + blipID)
            );
        }
}
