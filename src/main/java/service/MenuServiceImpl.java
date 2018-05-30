package service;

import authorized.AuthorizedUser;
import exception.NotAccessException;
import exception.NotFoundException;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;

import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;
import static util.ValidationUtil.hasAccess;

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
    public Menu create(Menu menu, int restId) {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        return repository.save(menu, restId);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public Menu get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Menu> getAll(int restId) {
        return repository.getAll(restId);
    }

    @Override
    public void update(Menu menu, int restId) {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        checkNotFoundWithId(repository.save(menu, restId),menu.getId());
    }
}
