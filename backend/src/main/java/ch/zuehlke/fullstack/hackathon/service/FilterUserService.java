package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilterUserService {

    private UserService userService;

    public List<UserWithInsightData> filter(Long[] interests, String location) {

        List<UserWithInsightData> userByInterests = filterByInterests(interests);
        List<UserWithInsightData> userByLocation = filterByLocation(location);

        return userByInterests.stream().filter(userByLocation::contains).collect(Collectors.toList());
    }

    private List<UserWithInsightData> filterByLocation(String location){
        List<UserWithInsightData> allUsersWithInsightData = userService.getAllUsersWithInsightData();
        if (location == null || location.isEmpty()){
            return allUsersWithInsightData;
        }
        return allUsersWithInsightData.stream()
                .filter(userWithInsightData -> userWithInsightData.getInsightAddress().getCity().equals(location))
                .collect(Collectors.toList());
    }

    private List<UserWithInsightData> filterByInterests(Long[] interests){
        Collection<User> users = userService.getAll();

        if (interests != null) {
            users = users.stream()
                    .filter(
                            user -> user.getInterests().stream().anyMatch(interest -> Arrays.asList(interests).contains(interest.getInterestID()))
                    )
                    .collect(Collectors.toList());
        }

        return users.stream()
                .map(user -> userService.getUserWithAddress(user.getCode()))
                .collect(Collectors.toList());
    }

}
