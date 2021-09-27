package ch.zuehlke.fullstack.hackathon.service.repository;

import ch.zuehlke.fullstack.hackathon.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InterestRepository extends JpaRepository<Interest, Long> {

}
