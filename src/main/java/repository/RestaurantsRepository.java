package repository;


import model.Restaurant;

import java.util.List;

public interface RestaurantsRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    Restaurant getWithMenu(int id);

}
