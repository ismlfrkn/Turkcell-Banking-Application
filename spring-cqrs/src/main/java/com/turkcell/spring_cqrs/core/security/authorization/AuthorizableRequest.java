package com.turkcell.spring_cqrs.core.security.authorization;

public interface AuthorizableRequest {
    default String[] requiredRoles() {
        return new String[]{};
    }
}
