package spittrtest.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateSpitterHandler {
    @ExceptionHandler(DuplicateSpitterException.class)
    public String DuplicateSpitter(){
        return "error/duplicate";
    }
}
