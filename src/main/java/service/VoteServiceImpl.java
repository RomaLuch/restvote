package service;

import exception.NotTwiseException;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteRepository;

import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
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
            throw new NotTwiseException("You can not vote twice");
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
