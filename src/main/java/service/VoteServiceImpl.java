package service;

import exception.NotVotingTimeException;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteServiceImpl implements VoteService {


    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote create(int userId, int restId) {
        Vote vote = repository.save(userId, restId, LocalDate.now());
        if (vote == null) {
            throw new NotVotingTimeException("You can not voting beatween 11:00 and 18:00");
        }
        return vote;
    }

    @Override
    public void delete(int userId) {
        checkNotFoundWithId(repository.delete(userId), userId);
    }


    @Override
    public List<Vote> getAll() {
        return repository.getAll();
    }
}
