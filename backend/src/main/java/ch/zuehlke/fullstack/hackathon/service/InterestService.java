package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.controller.dto.AddInterestDto;
import ch.zuehlke.fullstack.hackathon.controller.dto.InterestDto;
import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.model.User;
import ch.zuehlke.fullstack.hackathon.service.mapper.InterestMapper;
import ch.zuehlke.fullstack.hackathon.service.repository.InterestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;

@Service
@AllArgsConstructor
public class InterestService {

    private InterestRepository interestRepository;
    private UserService userService;
    private CategoryService categoryService;

    public Interest getInterestBy(long id) {
        return interestRepository.findById(id).orElseThrow(FindException::new);
    }

    public Interest create(Interest interest) {
        return interestRepository.save(interest);
    }

    public InterestDto addInterestToUser(String code, AddInterestDto addInterestDto) {
        User user = userService.getUserBy(code);
        if (addInterestDto.getId() == null || interestRepository.findById(addInterestDto.getId()).isEmpty()) {
            Interest interest = createInterestObject(addInterestDto, user);
            return InterestMapper.toInterestDto(create(interest));
        }
        Interest interest = interestRepository.findById(addInterestDto.getId()).get();
        if (!interest.getUserCollection().contains(user)) {
            interest.getUserCollection().add(user);
            return InterestMapper.toInterestDto(create(interest));
        }
        return InterestMapper.toInterestDto(interest);
    }

    public void removeInterestFromUser(String code, Long interestId){
        User user = userService.getUserBy(code);
        Interest interest = getInterestBy(interestId);
        userService.removeInterestFromUser(interest, user);
    }

    private Interest createInterestObject(AddInterestDto addInterestDto, User user) {
        Category category = categoryService.getCategoryBy(addInterestDto.getCategoryId());
        Interest interest = new Interest();
        interest.setCategory(category);
        interest.setName(addInterestDto.getName());
        interest.setUserCollection(List.of(user));
        return interest;
    }

}
