package com.turkcell.spring_cqrs.application.features.category.command.create;

import org.hibernate.validator.constraints.Length;

// Command-Query -> DTO

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;
import com.turkcell.spring_cqrs.core.security.authorization.AuthorizableRequest;

import jakarta.validation.constraints.NotBlank;

//Request Dto
public record CreateCategoryCommand
(
    @NotBlank
    @Length(min = 5,max = 100)
    String name
) 
implements Command<CreatedCategoryResponse>,AuthorizableRequest {
    @Override
    public String[] requiredRoles() {
        return new String[]{"ADMIN"};
    }
}