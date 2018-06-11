package repository;

import model.Vote;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
public interface VoteRepository {
    // return new
    Vote save(int userId, int restId, LocalDateTime date_time);

    // false if not found
    boolean delete(int id);

    // null if not found

    List<Vote> getAll();
}

