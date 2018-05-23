package repository;

import model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Menu save(Menu menu);

    @Query("SELECT m FROM Menu m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Menu> getAll(@Param("userId") int userId);
}
