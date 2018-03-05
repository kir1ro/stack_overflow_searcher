package com.romanov.stack.exchange.consumer.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public String getErrorPage(Model model, Exception ex) {
        model.addAttribute("message", ex.getMessage());
        return "error_page";
    }
}
