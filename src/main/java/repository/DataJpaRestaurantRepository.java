package repository;

import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RLuchinsky on 21.05.2018.
 */
@Repository
public class DataJpaRestaurantRepository implements RestaurantsRepository {

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Restaurant get(int id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public Restaurant getWithMenu(int id) {
        return null;
    }
}
