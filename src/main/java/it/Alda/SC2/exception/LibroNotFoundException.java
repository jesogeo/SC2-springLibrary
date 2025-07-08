package it.Alda.SC2.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }

}
