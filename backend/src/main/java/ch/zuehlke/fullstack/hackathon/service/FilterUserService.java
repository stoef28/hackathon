package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class FilterUserService {

    @Autowired
    private UserService userService;

    public Collection<User> filter(Integer[] interests, int locationID) {
        Collection<User> userCollection = userService.getAll();
        userCollection = filterByLocation(userCollection, locationID);
        userCollection = filterByInterests(userCollection, interests);

        return userCollection;
    }

    private Collection<User> filterByLocation(Collection<User> userCollection, int locationID) {
        if (locationID <= 0)
            return userCollection;

        return userCollection.stream()
                .filter(user -> user.getLocation().getLocationID()==locationID)
                .collect(Collectors.toList());
    }

    private Collection<User> filterByInterests(Collection<User> userCollection, Integer[] interests) {
        if (interests == null || interests.length != 0)
            return userCollection;

        return userCollection.stream()
                .filter(user -> !user.getInterestCollection().stream().filter(interest -> true).collect(Collectors.toList()).isEmpty())
                .collect(Collectors.toList());
    }
}
