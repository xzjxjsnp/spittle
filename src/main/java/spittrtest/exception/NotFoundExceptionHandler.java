package spittrtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import spittrtest.error.Error;

@ControllerAdvice
public class NotFoundExceptionHandler {
//    @ExceptionHandler(SpittleNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public String spittleNotFoundHandler(){
//        return "error/notFound";
//    }

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody Error spittleNotFoundHandler(SpittleNotFoundException e){
        long spittleid = e.getSpittleid();
        return new Error(4, "Spittle [" + spittleid+ "] not found" );
    }

    @ExceptionHandler(SpitterNotFoundException.class)
    public String spitterNotFoundHandler(){
        return "error/spitterNotFound";
    }
}
