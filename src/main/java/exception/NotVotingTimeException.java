package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You can not vote twice")
public class NotVotingTimeException extends RuntimeException {
    public NotVotingTimeException(String message) {
        super(message);
    }
}
