package util;

import exception.NotFoundException;
import exception.NotVotingTimeException;

import java.time.LocalTime;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String arg) {
        if (!found) {
            throw new NotFoundException(arg);
        }
    }


    public static boolean isVotingTime()
    {
        LocalTime deadLine = LocalTime.of(11,00);
        LocalTime currentTime = LocalTime.now();
        LocalTime startVotingTime = LocalTime.of(06,00);

/* if need includ 11:00 and 06:00 (boundary values) can use it
        if (!(currentTime.compareTo(deadLine)<=0 && currentTime.compareTo(startVotingTime)>=0))
        {
        }
        */
        return currentTime.isBefore(deadLine) && currentTime.isAfter(startVotingTime);

    }
}
