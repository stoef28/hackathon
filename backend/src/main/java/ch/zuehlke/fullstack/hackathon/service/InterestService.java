package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.service.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;

@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    public Interest getInterestBy(long id) {
        return interestRepository.findById(id).orElseThrow( () -> new FindException());
    }

    public Interest create(Interest interest) {
        return interestRepository.save(interest);
    }

}
