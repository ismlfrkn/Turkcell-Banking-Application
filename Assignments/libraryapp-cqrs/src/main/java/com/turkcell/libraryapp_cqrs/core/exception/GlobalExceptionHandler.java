package com.turkcell.libraryapp_cqrs.core.exception;

import com.turkcell.libraryapp_cqrs.core.exception.response.ErrorResponse;
import com.turkcell.libraryapp_cqrs.core.exception.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return new ErrorResponse(
                "User Already Exists",
                "USER_ALREADY_EXISTS",
                exception.getMessage()
        );
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleInvalidCredentialsException(InvalidCredentialsException exception) {
        return new ErrorResponse(
                "Invalid Credentials",
                "INVALID_CREDENTIALS",
                exception.getMessage()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse(
                "Not Found",
                "NOT_FOUND",
                exception.getMessage()
        );
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException exception) {
        return new ErrorResponse(
                "Business Rule Violation",
                "BUSINESS_EXCEPTION",
                exception.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorResponse(
                        error.getField(),
                        List.of(error.getDefaultMessage())
                ))
                .toList();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        return new ErrorResponse(
                "Internal Server Error",
                "INTERNAL_SERVER_ERROR",
                "Beklenmeyen bir hata oluştu."
        );
    }
}