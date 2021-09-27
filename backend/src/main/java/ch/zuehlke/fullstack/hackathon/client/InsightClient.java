package ch.zuehlke.fullstack.hackathon.client;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class InsightClient {
    RestTemplate restTemplate;

    public InsightUserData getInsightUserData(User user) {
        return restTemplate.getForObject("employees/" + user.getCode(), InsightUserData.class);
    }

    public byte[] getInsightProfilePicture(User user) {
        return restTemplate.getForObject("/pictures/" + user.getPictureId(), byte[].class);
    }
}
