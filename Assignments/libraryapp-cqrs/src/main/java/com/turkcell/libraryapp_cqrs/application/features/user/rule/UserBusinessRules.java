package com.turkcell.libraryapp_cqrs.application.features.user.rule;

import org.springframework.stereotype.Component;

@Component
public class UserBusinessRules {
    public void userWithSameEmailMustNotExist(String email)
    {
        // daha sonra oluşturulucak
    }
}
