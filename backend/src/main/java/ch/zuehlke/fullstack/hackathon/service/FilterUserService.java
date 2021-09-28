package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilterUserService {

    private UserService userService;

    public Collection<User> filter(Integer[] interests) {
        return filter(interests, 0);
    }

    public Collection<User> filter(int locationID) {
        return filter(null, locationID);
    }

    public Collection<User> filter(Integer[] interests, int locationID) {
        Collection<User> userCollection = userService.getAll();
        userCollection = filterByLocation(userCollection, locationID);
        userCollection = filterByInterests(userCollection, interests);

        return userCollection;
    }

    private Collection<User> filterByLocation(Collection<User> userCollection, int locationID) {
        if (locationID <= 0)
            return userCollection;

        // TODO filtern nach location
        return userCollection;
    }

    private Collection<User> filterByInterests(Collection<User> userCollection, Integer[] interests) {
        if (interests == null || interests.length != 0)
            return userCollection;

        return userCollection.stream()
                .filter(
                        user -> user.getInterests().stream()
                                .filter(interest -> Arrays.asList(interests).contains(interest.getInterestID()))
                                .count() > 0
                )
                .collect(Collectors.toList());
    }
}
