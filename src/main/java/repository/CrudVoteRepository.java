package repository;

import model.User;
import model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.user.id=:user_id")
    int delete(@Param("user_id") int userId);

    @Override
    @Transactional
    Vote save(Vote vote);

    @Override
    List<Vote> findAll();

    Vote findByUserIdAndDate(int userId, LocalDate date);

}

