package com.turkcell.libraryapplication.dto.response;

import java.util.List;

public class ValidationErrorResponse {

    private String argument;
    private List<String> messages;

    public ValidationErrorResponse() {
    }

    public ValidationErrorResponse(String argument, List<String> messages) {
        this.argument = argument;
        this.messages = messages;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}