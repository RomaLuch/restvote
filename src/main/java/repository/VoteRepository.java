package repository;

import model.Vote;

import java.util.List;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
public interface VoteRepository {
    // return new
    Vote save(int userId, int restId);

    // false if not found
    boolean delete(int id);

    // null if not found

    Integer getAll(int restId);
}

