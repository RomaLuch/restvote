package repository;

import model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by RLuchinsky on 21.05.2018.
 */
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant user);

    @Override
    Optional<Restaurant> findById(Integer id);

    @Override
    List<Restaurant> findAll();

    Restaurant getByEmail(String email);

}
