package service;

import exception.NotAccessException;
import exception.NotFoundException;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantsRepository;

import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;
import static util.ValidationUtil.hasAccess;

/**
 * Created by RLuchinsky on 21.05.2018.
 */

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantsRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id),id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Restaurant restaurant) {
        if(!hasAccess()) {throw new NotAccessException("you do not have access rights");}
        checkNotFoundWithId(repository.save(restaurant),restaurant.getId());
    }
}
