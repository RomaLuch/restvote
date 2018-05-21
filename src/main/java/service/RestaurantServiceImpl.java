package service;

import exception.NotFoundException;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantsRepository;

import java.util.List;

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
    public Restaurant create() {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Restaurant restaurant) {

    }
}
