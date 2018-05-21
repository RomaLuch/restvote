package exception;

/**
 * Created by RLuchinsky on 21.05.2018.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
