package ch.zuehlke.fullstack.hackathon.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@RequiredArgsConstructor
public class InsightClientConfiguration {

    @Value("${insight.credentials.username}")
    private String username;
    @Value("${insight.credentials.password}")
    private String password;

    @Bean
    public InsightClient insightClient(final RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .basicAuthentication(username, password)
                .uriTemplateHandler(new DefaultUriBuilderFactory("https://insight.zuehlke.com/api/v1/"))
                .build();
        return new InsightClient(restTemplate, new ObjectMapper());
    }
}
