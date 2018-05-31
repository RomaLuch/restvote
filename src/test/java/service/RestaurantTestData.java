package service;

import model.Restaurant;

import java.util.Arrays;

import static model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;


public class RestaurantTestData {
    public static final int TOKIO_ID = START_SEQ;
    public static final int EVRASIA_ID = START_SEQ + 1;
    public static final int ULIBKA_ID = START_SEQ + 2;

    public static Restaurant TOKIO = new Restaurant(TOKIO_ID, "Токио", "Солнечное", 0);
    public static Restaurant EVRASIA = new Restaurant(EVRASIA_ID, "Евразия", "Сестрорецк", 0);
    public static Restaurant ULIBKA = new Restaurant(ULIBKA_ID, "Улыбка", "Зеленогорск", 2);


    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Restaurant > actual, Restaurant ... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant > actual, Iterable<Restaurant > expected) {
        assertThat(actual).usingElementComparatorOnFields("id","name","adress","rating").isEqualTo(expected);
    }
}

