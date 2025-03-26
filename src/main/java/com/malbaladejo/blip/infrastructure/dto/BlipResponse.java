package com.malbaladejo.blip.infrastructure.dto;

import com.malbaladejo.blip.domain.Blip;

import java.util.UUID;

public record BlipResponse(UUID blipId, UUID userId, String content, String timestamp) {
    public static BlipResponse fromBlip(Blip blip) {
        return new BlipResponse(
                blip.getBlipId(),
                blip.getUserId(),
                blip.getContent().getValue(),
                blip.getTimestamp().toString());
    }
}