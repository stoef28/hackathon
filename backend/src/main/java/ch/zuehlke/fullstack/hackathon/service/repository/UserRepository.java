package ch.zuehlke.fullstack.hackathon.service.repository;

import ch.zuehlke.fullstack.hackathon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByCode(String code);
}
