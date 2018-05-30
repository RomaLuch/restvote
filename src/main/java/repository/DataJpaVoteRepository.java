package repository;

import model.Restaurant;
import model.User;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
@Repository
public class DataJpaVoteRepository implements VoteRepository {

    @Autowired
    CrudVoteRepository repository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    private  CrudUserRepository crudUserRepository;

    @Override
    public Vote save(int userId, int restId) {
        User user = crudUserRepository.findById(userId).orElse(null);
        Restaurant restaurant = crudRestaurantRepository.getOne(restId);
        return  repository.save(new Vote(user, restaurant));
    }

    @Override
    public boolean delete(int userId) {
        return repository.delete(userId)!= 0;
    }

    @Override
    public Integer getAll(int restId) {
        return repository.countByRestaurantId(restId);
    }
}
