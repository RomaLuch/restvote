package service;

import exception.NotFoundException;
import model.Menu;

import java.util.List;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
public interface MenuService {

    Menu create(Menu menu, int restId);

    void delete(int id) throws NotFoundException;

    Menu get(int id) throws NotFoundException;

    List<Menu> getAll(int restId);

    void update(Menu menu);
}
