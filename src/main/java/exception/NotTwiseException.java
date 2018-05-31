package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by RLuchinsky on 31.05.2018.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You can not vote twice")
public class NotTwiseException extends RuntimeException {
    public NotTwiseException(String message) {
        super(message);
    }
}
