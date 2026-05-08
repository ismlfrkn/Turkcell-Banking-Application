package com.turkcell.libraryapp_cqrs.core.mediator.pipeline;

@FunctionalInterface
public interface RequestHandlerDelegate<R> {
    R invoke();
}