package com.turkcell.libraryapp_cqrs.application.features.user.command.login;

import com.turkcell.libraryapp_cqrs.core.logging.NotLoggableRequest;
import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.Command;

public record LoginCommand(String email, String password) implements Command<LoginResponse>, NotLoggableRequest {}