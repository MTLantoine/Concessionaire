package project.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistingException extends Exception {

    public AlreadyExistingException() {
        super();
    }

    public AlreadyExistingException(String message) {
        super(message);
    }
}
