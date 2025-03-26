package com.malbaladejo.blip.infrastructure.controllers;

import com.malbaladejo.blip.application.CeateBlipUseCase;
import com.malbaladejo.blip.application.GetBlipUseCase;
import com.malbaladejo.blip.application.GetLatestBlipsUseCase;
import com.malbaladejo.blip.domain.Blip;
import com.malbaladejo.blip.infrastructure.dto.BlipResponse;
import com.malbaladejo.blip.infrastructure.dto.CreateBlipRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blips")
public class BlipController {
    private final CeateBlipUseCase createBlipUseCase;
    private final GetBlipUseCase getBlipUseCase;
    private final GetLatestBlipsUseCase getLatestBlipsUseCase;

    @GetMapping("/{blipId}")
    public ResponseEntity<BlipResponse> getBlip(@PathVariable UUID blipId) {
        Blip blip = getBlipUseCase.execute(blipId);
        BlipResponse response = BlipResponse.fromBlip(blip);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BlipResponse>> getLatestBlip() {
        List<Blip> blips = getLatestBlipsUseCase.execute();
        List<BlipResponse> responses = blips.stream()
                .map(BlipResponse::fromBlip)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<BlipResponse> createBlip(@Valid @RequestBody CreateBlipRequest request) {
        Blip blip = createBlipUseCase.execute(request.userId(), request.content());
        BlipResponse response = BlipResponse.fromBlip(blip);
        return ResponseEntity.status(201).body(response);
    }

}
