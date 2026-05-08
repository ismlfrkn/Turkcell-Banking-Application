package com.turkcell.libraryapp_cqrs.core.performance;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.libraryapp_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.libraryapp_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(1)
public class PerformanceMonitoringBehavior implements PipelineBehavior {

    private static final long THRESHOLD_MS = 3000;

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        String requestName = request.getClass().getSimpleName();
        long start = System.currentTimeMillis();

        R response = next.invoke();

        long elapsed = System.currentTimeMillis() - start;

        if (elapsed > THRESHOLD_MS) {
            System.out.println("[PERFORMANCE] UYARI! " + requestName
                + " " + elapsed + "ms sürdü (eşik: " + THRESHOLD_MS + "ms)");
        }

        return response;
    }

}