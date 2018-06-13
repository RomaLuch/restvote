package repository;

import model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    // return new
    Vote save(int userId, int restId, LocalDate date);

    // false if not found
    boolean delete(int id);

    // null if not found

    List<Vote> getAll();
}

