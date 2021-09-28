package ch.zuehlke.fullstack.hackathon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Value("${user.loggedIn}")
    private String userCode;

    public String getLoggedInUserCode() {
        return userCode;
    }
}
