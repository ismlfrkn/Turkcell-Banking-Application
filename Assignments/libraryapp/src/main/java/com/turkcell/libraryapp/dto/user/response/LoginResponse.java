package com.turkcell.libraryapp.dto.user.response;

import java.util.UUID;

public record LoginResponse(
        UUID userId,
        String email,
        String message
) {
}