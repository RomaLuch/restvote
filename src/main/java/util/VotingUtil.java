package util;

import model.Restaurant;
import model.Role;
import model.User;
import model.Vote;
import to.RestaurantWithVotes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by RLuchinsky on 09.06.2018.
 */
public class VotingUtil {

/*
    public static void main(String[] args) {
        User first = new User(1,"Roma","123","123", Role.ROLE_ADMIN);
        User second = new User(2,"Roma1","1234","1234", Role.ROLE_ADMIN);
        User third = new User(3,"Roma2","12345","12345", Role.ROLE_ADMIN);
        Restaurant restaurant = new Restaurant(1,"1","1");
        Vote vote1 = new Vote(first, restaurant, LocalDateTime.now());
        Vote vote2 = new Vote(second, restaurant, LocalDateTime.now());
        Vote vote3 = new Vote(first, restaurant, LocalDateTime.of(2018,06,10,06,00));

        List<Vote> votes = new ArrayList<>();
        votes.add(vote1);
        votes.add(vote2);
        votes.add(vote3);

        getWithVotes(votes).stream().forEach(System.out::println);


         }
*/
    public static List<RestaurantWithVotes> getWithVotes(Collection<Vote> votes)
    {
        List<Vote> currentDayVotes = votes.stream()
                 .filter(v->v.getDateTime().toLocalDate().isEqual(LocalDate.now()))
                 .collect(Collectors.toList());

        Map<Restaurant, Integer> rating = new HashMap<>();
        for (Vote vote: currentDayVotes) {
            rating.compute(vote.getRestaurant(), (restaurant, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }

        List<RestaurantWithVotes> result = rating.entrySet()
                .stream()
                .map(r ->
                createWithVotes(r.getKey(), r.getValue()))
                .collect(Collectors.toList());
        ;

return result;
    }

    public static RestaurantWithVotes createWithVotes(Restaurant restaurant, Integer amountOfVoting) {
        return new RestaurantWithVotes(restaurant.getId(),restaurant.getName(), restaurant.getAdress(), amountOfVoting);
    }
    }

