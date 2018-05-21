package repository;

import model.User;

import java.util.List;

/**
 * Created by RLuchinsky on 18.05.2018.
 */
public interface DataJpaUserRepository {

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

}
