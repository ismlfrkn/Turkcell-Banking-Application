package com.turkcell.libraryapp.exception.response;

public record ErrorResponse(
        String title,
        String type,
        String message
) {
}