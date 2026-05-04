package com.turkcell.libraryapp.exception.response;

import java.util.List;

public record ValidationErrorResponse(
        String argument,
        List<String> messages
) {
}