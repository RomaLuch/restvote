package service;

import model.Vote;

import java.util.List;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
public interface VoteService {

    Vote create(int userId, int restId);

    void delete(int id);

    Integer countByRestaurantId(int restId);

}
