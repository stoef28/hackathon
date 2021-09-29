package ch.zuehlke.fullstack.hackathon.config;

import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.model.User;
import ch.zuehlke.fullstack.hackathon.service.repository.CategoryRepository;
import ch.zuehlke.fullstack.hackathon.service.repository.InterestRepository;
import ch.zuehlke.fullstack.hackathon.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GenerateTestdata {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private UserRepository userRepository;

    private List<Category> categoryList = new ArrayList<>();
    private List<Interest> interestList = new ArrayList<>();

    @Bean
    public void createTestData() {
        createCategoryList();
        createInterestList();
        createUsers();
    }

    private void createCategoryList() {
        Category category1 = new Category();
        category1.setName("Sport");

        Category category2 = new Category();
        category2.setName("Musik");

        Category category3 = new Category();
        category3.setName("Kunst");

        Category category4 = new Category();
        category4.setName("Handwerk");

        Category category5 = new Category();
        category5.setName("Andere");

        categoryList.add(categoryRepository.save(category1));
        categoryList.add(categoryRepository.save(category2));
        categoryList.add(categoryRepository.save(category3));
        categoryList.add(categoryRepository.save(category4));
        categoryList.add(categoryRepository.save(category5));
    }

    private void createInterestList() {
        createInterest("Fussball", 0);
        createInterest("Tennis", 0);
        createInterest("Velo fahren", 0);
        createInterest("Golf", 0);
        createInterest("Ski", 0);

        createInterest("Piano", 1);
        createInterest("Singen", 1);
        createInterest("Gitarre", 1);

        createInterest("Zeichnen", 2);

        createInterest("Gartenarbeit", 3);
        createInterest("Schreinern", 3);
        createInterest("Modelbau", 3);
        createInterest("Basteln", 3);

        createInterest("Häkeln", 4);
        createInterest("Imkern", 4);
        createInterest("Freiwilligenarbeit", 4);
    }

    private void createInterest(String name, int categoryIndex) {
        Interest interest = new Interest();
        interest.setName(name);
        interest.setCategory(categoryList.get(categoryIndex));

        interestRepository.save(interest);
        interestList.add(interest);
    }


    private void createUsers() {
        User user1 = getUser("geze", new int[]{1, 2, 4, 5});
        userRepository.save(user1);

        User user2 = getUser("steb", new int[]{0, 3, 7, 13});
        userRepository.save(user2);

        User user3 = getUser("jage", new int[]{2, 7});
        userRepository.save(user3);

        User user4 = getUser("lybo", new int[]{13});
        userRepository.save(user4);

        User user5 = getUser("fapl", new int[]{0, 4, 14});
        userRepository.save(user5);

        User user6 = getUser("ndu", new int[]{4, 13, 14});
        userRepository.save(user6);

        User user7 = getUser("sti", new int[]{7});
        userRepository.save(user7);

        User user8 = getUser("scsl", new int[]{3, 5, 8});
        userRepository.save(user8);

        User user9 = getUser("moal", new int[]{12, 5, 7});
        userRepository.save(user9);

        User user10 = getUser("kege", new int[]{4});
        userRepository.save(user10);

        User user11 = getUser("anha", new int[]{0, 3, 5, 10});
        userRepository.save(user11);
    }

    private User getUser(String code, int[] interestListIndexes) {
        User user = new User();
        user.setCode(code);

        for (int i : interestListIndexes)
            user.addInterest(interestList.get(i));

        return user;
    }
}
