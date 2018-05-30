package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by RLuchinsky on 30.05.2018.
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "No access")
public class NotAccessException extends RuntimeException {
    public NotAccessException(String message) {
        super(message);
    }
}
