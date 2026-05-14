package com.turkcell.spring_cqrs.core.security.authorization;

import java.util.Arrays;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.spring_cqrs.core.security.context.UserContext;
import com.turkcell.spring_cqrs.core.security.exception.UnauthenticatedException;
import com.turkcell.spring_cqrs.core.security.exception.UnauthorizedException;

@Component
@Order(10)
public class AuthorizationBehavior implements PipelineBehavior {
    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        
        //Özel bir exception türü belirle.
        //Handlerda bu exceptionı eğer giriş yapılmamışsa 401, (UnauthenticatedException) dönecek şekilde yakala..
        //yapılmış ancak rol yetersiz ise 403 (UnauthorizedException) dönecek şekilde yakala..
        //düzenle..

        if (!(request instanceof AuthorizableRequest authRequest))
            return next.invoke();

        if (!userContext.isAuthenticated())
            throw new UnauthenticatedException();

        String[] requiredRoles = authRequest.requiredRoles();
        if (requiredRoles.length > 0) {
            boolean hasRole = Arrays.stream(requiredRoles)
                    .anyMatch(role -> userContext.getRoles().contains(role));
            if (!hasRole)
                throw new UnauthorizedException();
        }

        return next.invoke(); // zincirdeki sonraki halkayı çağır..
    }

}