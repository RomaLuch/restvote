package repository;

import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
@Repository
public class DataJpaMenuRepository implements MenuRepository {

    @Autowired
    private CrudMenuRepository crudMenuRepository;

    @Override
    @Transactional
    public Menu save(Menu restaurant) {
        return crudMenuRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return crudMenuRepository.delete(id) != 0;
    }

    @Override
    public Menu get(int id) {
        return crudMenuRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> getAll(int restId) {
        return crudMenuRepository.findAll();
    }

}

