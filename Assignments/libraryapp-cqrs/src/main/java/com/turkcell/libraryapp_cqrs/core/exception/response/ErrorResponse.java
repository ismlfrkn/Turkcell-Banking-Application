package com.turkcell.libraryapp_cqrs.core.exception.response;

public record ErrorResponse(
        String title,
        String type,
        String message
) {
}