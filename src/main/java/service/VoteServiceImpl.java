package service;

import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteRepository;

import java.util.List;

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
        return repository.save(userId, restId);
    }

    @Override
    public void delete(int userId) {
        repository.delete(userId);
    }

    @Override
    public Integer countByRestaurantId(int restId)
    {
        return repository.getAll(restId);
    }
}
