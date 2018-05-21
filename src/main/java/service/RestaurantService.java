package service;

import exception.NotFoundException;
import model.Restaurant;

import java.util.List;

/**
 * Created by RLuchinsky on 21.05.2018.
 */
public interface RestaurantService {

    Restaurant create();

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    List<Restaurant> getAll();

    void update(Restaurant restaurant);
}
