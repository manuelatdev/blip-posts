package com.malbaladejo.blip.application;

import com.malbaladejo.blip.domain.Blip;
import com.malbaladejo.blip.infrastructure.BlipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLatestBlipsUseCase {
    private final BlipRepository blipRepository;

    public List<Blip> execute(){
        return blipRepository.findLatest(10);
    }
}
