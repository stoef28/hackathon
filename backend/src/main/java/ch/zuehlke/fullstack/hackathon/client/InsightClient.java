package ch.zuehlke.fullstack.hackathon.client;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class InsightClient {

    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    public InsightUserData getInsightUserData(User user) {
        return restTemplate.getForObject("employees/" + user.getCode(), InsightUserData.class);
    }
}
