package com.turkcell.libraryapp_cqrs.core.logging;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.libraryapp_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.libraryapp_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(20)
public class LoggingBehavior implements PipelineBehavior {

    @Override
    public boolean supports(Object request) {
        return !(request instanceof NotLoggableRequest);
    }

    @Override
public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
    String requestName = request.getClass().getSimpleName();

    System.out.println("[LOG] İstek  | " + requestName + " -> " + request);

    R response = next.invoke();

    String responseName = response.getClass().getSimpleName();
    System.out.println("[LOG] Yanıt  | " + responseName + " <- " + response);

    return response;
}

}