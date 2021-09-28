package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.model.User;
import ch.zuehlke.fullstack.hackathon.service.mapper.UserWithInsightDataMapper;
import ch.zuehlke.fullstack.hackathon.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private InsightService insightService;
    private LoginService loginService;

    public User getUserBy(long id) {
        return userRepository.findById(id).orElseThrow(FindException::new);
    }

    public User addInterestToUser(Interest interest, User user) {
        Collection<Interest> interests = user.getInterests();
        interests.add(interest);
        user.setInterests(interests);

        return userRepository.save(user);
    }

    public User removeInterestFromUser(Interest interest, User user) {
        Collection<Interest> interests = user.getInterests();
        interests = interests.stream().filter(interestIter -> !interestIter.getInterestID().equals(interest.getInterestID())).collect(Collectors.toList());
        user.setInterests(interests);

        return userRepository.save(user);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public UserWithInsightData getUserWithAddress(String code){
        User user = userRepository.getUserByCode(code);
        InsightUserData insightUserData = insightService.getInsightUserData(user);
        return UserWithInsightDataMapper.mapToUserWithInsightData(insightUserData, user);
    }

    public UserWithInsightData getLoggedInUserWithAddress(){
        return getUserWithAddress(loginService.getLoggedInUserCode());
    }

    public String getProfilePictureOf(String code) {
        User user = userRepository.getUserByCode(code);
        InsightUserData insightUserData = insightService.getInsightUserData(user);
        return insightService.getInsightProfilePicture(insightUserData);
    }

    public Collection<User> getAll() {
        return userRepository.findAll();
    }

}
