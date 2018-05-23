package service;

import exception.NotFoundException;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;

import java.util.List;

/**
 * Created by RLuchinsky on 23.05.2018.
 */

@Service

public class MenuServiceImpl implements MenuService {

    private MenuRepository repository;

    @Autowired
    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public Menu create(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public void delete(int id) throws NotFoundException {
repository.delete(id);
    }

    @Override
    public Menu get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public List<Menu> getAll(int restId) {
        return repository.getAll(restId);
    }

    @Override
    public void update(Menu menu) {
repository.save(menu);
    }
}
