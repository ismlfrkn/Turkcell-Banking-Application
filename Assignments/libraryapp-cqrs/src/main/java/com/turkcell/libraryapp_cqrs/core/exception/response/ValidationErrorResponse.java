package com.turkcell.libraryapp_cqrs.core.exception.response;


import java.util.List;

public record ValidationErrorResponse(
        String argument,
        List<String> messages
) {
}