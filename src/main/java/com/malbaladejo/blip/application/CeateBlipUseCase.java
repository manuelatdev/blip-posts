package com.malbaladejo.blip.application;

import com.malbaladejo.blip.domain.Blip;
import com.malbaladejo.blip.domain.BlipContent;
import com.malbaladejo.blip.infrastructure.BlipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CeateBlipUseCase {
    private final BlipRepository blipRepository;

    public Blip execute(UUID userId, String content) {
        BlipContent blipContent = new BlipContent(content);
        Blip blip = new Blip(userId, blipContent);

        return blipRepository.save(blip);
    }

}
