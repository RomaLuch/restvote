package repository;

import model.User;
import model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by RLuchinsky on 30.05.2018.
 */
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM Vote v WHERE v.user.id=:user_id")
    int delete(@Param("user_id") int id);

    @Override
    @Transactional
    Vote save(Vote vote);

   // @Override
    Integer countByRestaurantId(int restaurantId);

}

