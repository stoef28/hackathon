package ch.zuehlke.fullstack.hackathon.controller;

import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserWithInsightData> getUser(@PathVariable(name = "id") String code){
        return ResponseEntity.ok(userService.getUserWithAddress(code));
    }

    @GetMapping("/{id}/picture")
    public ResponseEntity<String> getUserProfilePicture(@PathVariable(name = "id") String code){
        return ResponseEntity.ok(userService.getProfilePictureOf(code));
    }

}
