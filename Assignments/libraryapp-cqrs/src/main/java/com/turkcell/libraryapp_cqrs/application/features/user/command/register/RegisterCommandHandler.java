package com.turkcell.libraryapp_cqrs.application.features.user.command.register;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.turkcell.libraryapp_cqrs.application.features.user.rule.UserBusinessRules;
import com.turkcell.libraryapp_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.libraryapp_cqrs.domain.User;
import com.turkcell.libraryapp_cqrs.persistence.repository.UserRepository;

@Component
public class RegisterCommandHandler implements CommandHandler <RegisterCommand,RegisterResponse>
{
    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;
    private final PasswordEncoder passwordEncoder;

    public RegisterCommandHandler(UserRepository userRepository, UserBusinessRules userBusinessRules,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponse handle(RegisterCommand command) {
        this.userBusinessRules.userWithSameEmailMustNotExist(command.email());
        
        //todo: Move to mapper
        User user = new User();
        user.setEmail(command.email());
        user.setPasswordHash(passwordEncoder.encode(command.password()));
        userRepository.save(user);

        return new RegisterResponse(user.getUserId(),user.getEmail());
    }
    
}