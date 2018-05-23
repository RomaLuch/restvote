package repository;

import model.Menu;

import java.util.List;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
public interface MenuRepository {

    Menu save(Menu restaurant);

    boolean delete(int id);

    Menu get(int id);

    List<Menu> getAll(int restId);

}
