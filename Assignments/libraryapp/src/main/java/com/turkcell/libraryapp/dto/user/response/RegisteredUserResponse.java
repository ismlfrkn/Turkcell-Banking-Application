package com.turkcell.libraryapp.dto.user.response;

import java.util.UUID;

public record RegisteredUserResponse(
        UUID userId,
        String email
) {
}