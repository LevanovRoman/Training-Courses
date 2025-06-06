package com.myapp.training_backend.exceptions;

import com.myapp.training_backend.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> globalExceptionHandler(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND) // возможно это излишне - обрабатывает необработанные исключения
    @ExceptionHandler(ObjectNotFoundException.class)
    public MessageDto objectNotFoundException(ObjectNotFoundException ex){
        return new MessageDto(ex.getMessage());
    }
}
