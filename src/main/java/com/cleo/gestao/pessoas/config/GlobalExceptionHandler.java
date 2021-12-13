package com.cleo.gestao.pessoas.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getFieldErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return errors;
    }

}
