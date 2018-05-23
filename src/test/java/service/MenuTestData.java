package service;

import model.Menu;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by RLuchinsky on 23.05.2018.
 */
public class MenuTestData {

    public static final int SOLYANKA_ID = 100011;
    public static final Menu ULIBKA_MENU_1 = new Menu(SOLYANKA_ID, "Солянка", 70);
    public static final Menu ULIBKA_MENU_2 = new Menu(SOLYANKA_ID + 1, "Греча", 30);
    public static final Menu ULIBKA_MENU_3 = new Menu(SOLYANKA_ID + 2, "Говядина", 70);

    public static void assertMatch(Menu actual, Menu expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }

    public static void assertMatch(Iterable<Menu> actual, Menu ... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Menu> actual, Iterable<Menu> expected) {
        assertThat(actual).usingElementComparatorOnFields("id","name","price").isEqualTo(expected);
    }
}
