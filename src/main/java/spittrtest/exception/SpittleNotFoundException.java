package spittrtest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class SpittleNotFoundException extends RuntimeException {
    private long spittleid;
    public SpittleNotFoundException(long spittleid){
        this.spittleid = spittleid;
    }
}
