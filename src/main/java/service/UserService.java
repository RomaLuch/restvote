package service;

import exception.NotFoundException;
import model.User;

import java.util.List;

/**
 * Created by RLuchinsky on 18.05.2018.
 */
public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    List<User> getAll();

}
