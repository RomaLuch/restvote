package service;

import exception.NotVotingTimeException;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteRepository;

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
        Vote vote = repository.save(userId, restId);
        if (vote == null) {
            throw new NotVotingTimeException("You can not voting beatween 10:00 and 18:00");
        }
        return vote;
    }

    @Override
    public void delete(int userId) {
        checkNotFoundWithId(repository.delete(userId), userId);
    }

    @Override
    public Integer countByRestaurantId(int restId)
    {
        return repository.getAll(restId);
    }
}
