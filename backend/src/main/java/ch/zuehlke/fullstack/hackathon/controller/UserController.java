package ch.zuehlke.fullstack.hackathon.controller;

import ch.zuehlke.fullstack.hackathon.controller.dto.AddInterestDto;
import ch.zuehlke.fullstack.hackathon.controller.dto.InterestDto;
import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.service.FilterUserService;
import ch.zuehlke.fullstack.hackathon.service.InterestService;
import ch.zuehlke.fullstack.hackathon.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private InterestService interestService;
    private FilterUserService filterUserService;

    @GetMapping("/{code}")
    public ResponseEntity<UserWithInsightData> getUser(@PathVariable String code){
        return ResponseEntity.ok(userService.getUserWithAddress(code));
    }

    @GetMapping("/{code}/picture")
    public ResponseEntity<String> getUserProfilePicture(@PathVariable String code){
        return ResponseEntity.ok(userService.getProfilePictureOf(code));
    }

    @PostMapping("/{code}/interests")
    public ResponseEntity<InterestDto> addUserInterest(@PathVariable String code, @RequestBody AddInterestDto addInterestDto){
        return ResponseEntity.ok(interestService.addInterestToUser(code, addInterestDto));
    }

    @DeleteMapping("/{code}/interests/{interestId}")
    public ResponseEntity removeInterestFromUser(@PathVariable String code, @PathVariable Long interestId){
        interestService.removeInterestFromUser(code, interestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserWithInsightData>> getUserProfilePicture(@RequestParam(name = "location", required = false) String location, @RequestParam(name = "interests", required = false)Long[] interests){
        return ResponseEntity.ok(filterUserService.filter(interests, location));
    }

}
