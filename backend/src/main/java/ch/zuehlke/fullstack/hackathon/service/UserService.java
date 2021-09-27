package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.model.User;
import ch.zuehlke.fullstack.hackathon.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public User getUserBy(long id) {
        return userRepository.findById(id).orElseThrow(FindException::new);
    }

    public User addInterestToUser(Interest interest, User user) {
        Collection<Interest> interestCollection = user.getInterestCollection();
        interestCollection.add(interest);
        user.setInterestCollection(interestCollection);

        return userRepository.save(user);
    }

    public User removeInterestFromUser(Interest interest, User user) {
        Collection<Interest> interestCollection = user.getInterestCollection();
        interestCollection = interestCollection.stream().filter(interestIter -> !interestIter.getInterestID().equals(interest.getInterestID())).collect(Collectors.toList());
        user.setInterestCollection(interestCollection);

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

}
