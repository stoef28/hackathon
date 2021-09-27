package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.*;
import ch.zuehlke.fullstack.hackathon.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserBy(long id) {
        return userRepository.findById(id).orElseThrow( () -> new FindException());
    }

    public User addInterestToUser(Interest interest, User user) {
        Collection<Interest> interestCollection = user.getInterestCollection();
        interestCollection.add(interest);
        user.setInterestCollection(interestCollection);

        return userRepository.save(user);
    }

    public User removeInterestFromUser(Interest interest, User user) {
        Collection<Interest> interestCollection = user.getInterestCollection();
        interestCollection = interestCollection.stream().filter(interestIter -> interestIter.getInterestID() != interest.getInterestID()).collect(Collectors.toList());
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
