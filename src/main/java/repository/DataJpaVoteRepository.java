package repository;

import model.Restaurant;
import model.User;
import model.Vote;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static util.ValidationUtil.isVotingTime;


@Repository
public class DataJpaVoteRepository implements VoteRepository {


private static final Logger log = getLogger(DataJpaVoteRepository.class);

    @Autowired
    CrudVoteRepository repository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    private  CrudUserRepository crudUserRepository;

    @Override
    public Vote save(int userId, int restId, LocalDateTime date_time) {

        if(!isVotingTime()) {
            return null;
        }

        Restaurant restaurant = crudRestaurantRepository.findById(restId).orElse(null);
        User user = crudUserRepository.findById(userId).orElse(null);

        if(user==null || restaurant==null) {return null;} //todo must throw another exception extend runtime

        delete(userId);

        Vote vote = new Vote(user, restaurant, date_time);

        log.info("Vote to Save = "+ vote);

        return repository.save(vote);
    }

    @Override
    public boolean delete(int userId) {
        Vote vote = repository.findByUserId(userId);
        if(vote==null)
        {
            return false;
        }

        return repository.delete(userId)!= 0;
    }

    @Override
    public List<Vote> getAll() {
        return repository.findAll();
    }
}
